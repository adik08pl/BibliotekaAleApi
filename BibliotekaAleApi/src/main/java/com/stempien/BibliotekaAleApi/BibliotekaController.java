package com.stempien.BibliotekaAleApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BibliotekaController {
        @GetMapping("/books")
        @ResponseBody
        public String books(@RequestParam(required = false) Integer id , @RequestParam(required = false , defaultValue = "Mickiewicz") String name , @RequestParam(required = false , defaultValue = "2020") int year){
            String answer = "";
            List<String> listaKluczy = new ArrayList<>();
            listaKluczy.add("Mickiewicz");
            listaKluczy.add("Mazur");
            Map mapOfBooks = new HashMap();
            mapOfBooks.put("Mickiewicz","Adam Mickiewicz - 'Pan Tadeusz',2020");
            mapOfBooks.put("Mazur","Teresa Mazur - 'Topole',2005");
            if(id!=null){
                answer += "Dane książki o id = "+id+":\n";
                answer += (String) mapOfBooks.get(listaKluczy.get(id-1));
            }
            else {
                answer += (String) mapOfBooks.get(name);
            }
            return answer;
        }
    @GetMapping("/books/{id}")
    @ResponseBody
    public String books2(@PathVariable() Integer id , @RequestParam(required = false , defaultValue = "Mickiewicz") String name , @RequestParam(required = false) int year){
        String answer = "";
        List<String> listaKluczy = new ArrayList<>();
        listaKluczy.add("Mickiewicz");
        listaKluczy.add("Mazur");
        Map mapOfBooks = new HashMap();
        mapOfBooks.put("Mickiewicz","Adam Mickiewicz - 'Pan Tadeusz',"+year);
        mapOfBooks.put("Mazur","Teresa Mazur - 'Topole',"+year);
        if(id!=null){
            answer += "Dane książki o id = "+id+":\n";
            answer += (String) mapOfBooks.get(listaKluczy.get(id-1));
        }
        else {
            answer += (String) mapOfBooks.get(name);
        }
        return answer;
    }
    @GetMapping("/count/{operation}/{number1}/{number2}")
    @ResponseBody
    public String count(@PathVariable(required = false) int number1 , @PathVariable(required = false) int number2 , @PathVariable() String operation2 ,@RequestParam(required = false) String operation , @RequestParam(required = false) int number3 , @RequestParam(required = false) int number4){
        String answer = "";
        if(operation!=null){
            switch(operation){
                case "add":
                    answer += number1+" + "+number2+ " = "+(number1+number2);
                    break;
                case "substract":
                    answer += number1+" - "+number2+ " = "+(number1-number2);
                    break;
                case "multiply":
                    answer += number1+" * "+number2+ " = "+(number1*number2);
                    break;
                case "divide":
                    if(number2==0)
                        break;
                    answer += number1+" / "+number2+ " = "+(number1/number2);
                    break;
            }
        }
        else{
            switch(operation) {
                case "add":
                    answer += number3 + " + " + number4 + " = " + (number3 + number4);
                    break;
                case "substract":
                    answer += number3 + " - " + number4 + " = " + (number3 - number4);
                    break;
                case "multiply":
                    answer += number3 + " * " + number4 + " = " + (number3 * number4);
                    break;
                case "divide":
                    if (number4 == 0)
                        break;
                    answer += number3 + " / " + number4 + " = " + (number3 / number4);
                    break;
            }
        }
        return answer;
    }
    }

