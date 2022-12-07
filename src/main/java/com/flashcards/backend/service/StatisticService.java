package com.flashcards.backend.service;

import com.flashcards.backend.entities.Challenge;
import com.flashcards.backend.entities.Statistic;
import com.flashcards.backend.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.*;

@Service
public class StatisticService
{
    @Autowired
    StatisticRepository statisticRepository;
    //getting all challenges records
    public List<Statistic> getAllStatistics()
    {
        List<Statistic> statistics = new ArrayList<Statistic>();
        statisticRepository.findAll().forEach(statistic -> statistics.add(statistic));
        return statistics;
    }
    //getting a specific record
    public Statistic getStatisticById(Long id)
    {
        return statisticRepository.findById(id).get();
    }
    public void saveOrUpdate(Statistic statistic)
    {
        statisticRepository.save(statistic);
    }
    //deleting a specific record
    public void delete(Long id)
    {
        statisticRepository.deleteById(id);
    }

    public List<Statistic> getAllStatistics4User(String user) {
        List<Statistic> result = new ArrayList<>();
        if (user == null) {
            return Collections.emptyList();
        }
        statisticRepository.findAll().forEach(st -> {if (st.getUser()!=null && user.equals(st.getUser().getName())) result.add(st);});
        return result;
    }

    public List<Statistic> getMostMissed4User(String user) {
        List<Statistic> result =    new ArrayList<>();

        statisticRepository.findAll().forEach(st -> {if (st.getUser()!=null && st.getUser().getName().equals(user)&&st.getCorrect()==0) result.add(st);});

        Map<Statistic, Long> mossedMissed =
                result.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<Statistic, Long>comparingByValue(reverseOrder()).thenComparing(Map.Entry.comparingByValue()))
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {throw new IllegalStateException();}, LinkedHashMap::new));

        List<Statistic> res = new ArrayList<>();

        return new ArrayList<>(mossedMissed.keySet());
    }

}