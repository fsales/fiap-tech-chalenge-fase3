package br.com.fsales.parktech;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-word")
public class HelloWordController {

    /**
     * @return
     */
    @GetMapping
    public ResponseEntity<String> hello(
    ) {

        return ResponseEntity.ok(
                "Hello Word"
        );
    }
}
