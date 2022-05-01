package co.kr.apti.springbatch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j                      // log 사용을 위한 lombok 어노테이션
@RequiredArgsConstructor    // private final 객체의 생성자를 생성
@Configuration              // Spring Job Configuration
public class SimpleJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;      // Job Builder 생성
    private final StepBuilderFactory stepBuilderFactory;    // Step Builder 생성
    //------------------------------------------------------------------------
    //  Spring Batch 구성
    //  구성 요소
    //  Job : 배치 구성 요소중 최상단으로 여러 Step을 포함할 수 있음
    //  Step : 실질적으로 프로그램을 실행 하는 요소로 Tasklet과 (Reader, Processor, Writer) 로 구성됨
    //  Tasklet : Spring MVC에 @Component, @Bean 과 비슷한 역할
    //
    //------------------------------------------------------------------------
    @Bean
    public Job simpleJob() {
        // Job 빌더 생성
        return jobBuilderFactory.get("simpleJob")
                .start(simpleStep1())
                .build();
    }

    @Bean
    public Step simpleStep1() {
        // Step 빌더 생성
        return stepBuilderFactory.get("simpleStep1")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>> This is Step1");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

}
