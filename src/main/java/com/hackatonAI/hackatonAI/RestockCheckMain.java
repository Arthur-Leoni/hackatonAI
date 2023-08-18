package com.hackatonAI.hackatonAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class RestockCheckMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestockCheckMain.class, args);

        // Cria um ScheduledExecutorService com um único thread
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Define o intervalo de tempo para a execução do JOB (em segundos)
        int intervalo = 10; // Substitua X pelo valor do intervalo desejado

        // Agendamento do JOB para ser executado diariamente a cada X segundos
        scheduler.scheduleAtFixedRate(() -> job(context), 0, intervalo, TimeUnit.SECONDS);
    }

    public static void job(ConfigurableApplicationContext context) {
        // Recupera a instância de VeriyNotification do contexto do Spring
        VeriyNotification veriyNotification = context.getBean(VeriyNotification.class);

        // Executa o método para verificar os produtos
        veriyNotification.getAllWaitingProducts();
    }
}
