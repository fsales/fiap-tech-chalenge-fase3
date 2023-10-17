package br.com.fsales.parktech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-word")
public class HelloWordController {

    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * @return
     */
    @GetMapping
    public ResponseEntity<String> hello(
    ) {
        var u = new Usuario("Fábio","M");
        mongoTemplate.insert(u, "usuario");

        return ResponseEntity.ok(
                "Hello Word"
        );
    }

    record Usuario(String nome, String sexo){}
}
