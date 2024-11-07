package com.astrocode.user_mcs.producers;



import com.astrocode.user_mcs.dtos.EmailDTO;
import com.astrocode.user_mcs.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessage(UserModel userModel){
        var emailDto = new EmailDTO();

        emailDto.setUserId(userModel.getUserId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(userModel.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro! Aproveite todos os recursos da nossa plataforma.");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
