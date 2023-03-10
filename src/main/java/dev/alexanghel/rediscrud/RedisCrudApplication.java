package dev.alexanghel.rediscrud;

import dev.alexanghel.rediscrud.model.Student;
import dev.alexanghel.rediscrud.model.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisCrudApplication {

    public static void main(String args[]) {
        SpringApplication.run(RedisCrudApplication.class, args);
    }

// Jedis config
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory rcf) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(rcf);
        return template;
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student student = new Student("01", "jon doe", Student.Gender.MALE, 2);
            Student student2 = new Student("02", "jane doi", Student.Gender.FEMALE, 2);

            studentRepository.save(student);
            studentRepository.save(student2);

            Student s1 = studentRepository.findById("01").get();
            Student s2 = studentRepository.findById("02").get();
            System.out.println(s1);
            System.out.println(s2);

        };
    }
}
