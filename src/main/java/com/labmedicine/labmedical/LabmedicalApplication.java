package com.labmedicine.labmedical;

import com.labmedicine.labmedical.api.UsuarioController;
import com.labmedicine.labmedical.model.Usuario;
import com.labmedicine.labmedical.model.enums.TipoEspecializacao;
import com.labmedicine.labmedical.model.enums.TipoEstadoCivil;
import com.labmedicine.labmedical.model.enums.TipoGenero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class LabmedicalApplication {

  public static void main(String[] args) {
    SpringApplication.run(LabmedicalApplication.class, args);
  }

}
