package com.example.springreactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Flux<Student> findByFirstname(String firstname) {
        return studentRepository.findAllByFirstnameContainingIgnoreCase(firstname);
    }

    public Mono<Student> save(Student student) {
        return studentRepository.save(student);
    }

    public Flux<Student> findAll() {
        return studentRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id).subscribe();
    }
}
