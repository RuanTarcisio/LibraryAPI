package io.github.ruantarcisio.arquiteturaspring.montadora.config;

import io.github.ruantarcisio.arquiteturaspring.montadora.Motor;
import io.github.ruantarcisio.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorAspirado")
    public Motor motorAspirado(){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPT0-D");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean("motorEletrico")
    @Primary
    public Motor motorEletrico(){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("XPT0-01");
        motor.setLitragem(1.5);
        motor.setTipoMotor(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorTurbo")
    public Motor motorTurbo(){
        var motor = new Motor();
        motor.setCavalos(200);
        motor.setCilindros(8);
        motor.setModelo("XPT0-8");
        motor.setLitragem(3.0);
        motor.setTipoMotor(TipoMotor.TURBO);
        return motor;
    }
}
