#Cheese
package com.datorium.Datorium.API.DTOs;

public class Cheese {
    public String name;
    public int price;
}
#UpdateCheese
package com.datorium.Datorium.API.DTOs;

public class UpdateCheese {
    public Cheese cheese;
    public int cheeseIndex;
}
#CheeseShopController
  package com.datorium.Datorium.API.Controllers;
import com.datorium.Datorium.API.DTOs.Cheese;
import com.datorium.Datorium.API.DTOs.UpdateCheese;
import com.datorium.Datorium.API.Services.CheeseShopService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cheese")
public class CheeseShopController {
    private CheeseShopService cheeseShopService;
    public CheeseShopController(){
        cheeseShopService = new CheeseShopService();
    }

    @PostMapping("/add")
    public int add(@RequestBody Cheese cheese){
        return cheeseShopService.add(cheese);
    }

    @GetMapping("/get")
    public ArrayList<Cheese> get() {
        return cheeseShopService.get();
    }
   @PostMapping("/update")
   public Cheese update(@RequestBody UpdateCheese updateCheese) {
       return cheeseShopService.update(updateCheese.cheeseIndex, updateCheese.cheese);
    }
}
#CheeseShopService
  package com.datorium.Datorium.API.Services;
import com.datorium.Datorium.API.DTOs.Cheese;
import com.datorium.Datorium.API.Repo.CheeseShopRepository;

import java.util.ArrayList;

public class CheeseShopService {
    private CheeseShopRepository cheeseShopRepository;

    public CheeseShopService() {
        cheeseShopRepository = new CheeseShopRepository();
    }

    public int add(Cheese cheese) {
        return cheeseShopRepository.add(cheese);
    }

    public ArrayList<Cheese> get() {
        return cheeseShopRepository.get();
    }
    public Cheese update(int cheeseIndex, Cheese updateCheese){
        return cheeseShopRepository.update(cheeseIndex, updateCheese);
    }
}
#CheeseShopRepository
  package com.datorium.Datorium.API.Repo;
import com.datorium.Datorium.API.DTOs.Cheese;

import java.util.ArrayList;

public class CheeseShopRepository {
    private ArrayList<Cheese> cheeses = new ArrayList<>();

    public int add(Cheese cheese){
        cheeses.add(cheese);
        return cheeses.size();
    }

    public ArrayList<Cheese> get(){
        return cheeses;
    }

    public Cheese update(int cheeseIndex, Cheese updateCheese){
        var cheese = cheeses.get(cheeseIndex);
        cheese.name = updateCheese.name;
        cheese.price = updateCheese.price;

        return cheese;
    }

}
