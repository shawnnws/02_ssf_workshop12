package sg.nus.iss.visa.ssf.workshop_12a.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class RandomNumService {
    
    public List<Integer> generateRanNum(int number) {
        
        // Logic to generate parameter number of random integers
        return new Random().ints(1, 31).distinct().limit(number).boxed().collect(Collectors.toList());
    }

}
