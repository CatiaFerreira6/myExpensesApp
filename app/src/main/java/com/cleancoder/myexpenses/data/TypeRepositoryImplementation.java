package com.cleancoder.myexpenses.data;

import com.cleancoder.myexpenses.models.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeRepositoryImplementation implements TypeRepositoryContract {

    private List<Type> types = new ArrayList<>();

    public TypeRepositoryImplementation(){
        types.add(
                new Type("EXPENSE", "Expense")
        );

        types.add(
                new Type("INCOME", "Income")
        );
    }

    public Type get(Long id){
       for(Type type: types){
           if(type.getId().equals(id)){
               return type;
           }
       }

       return null;
    }

    public Type get(String code){
       for(Type type: types){
           if(type.getCode().toLowerCase().equals(code.toLowerCase())){
               return type;
           }
       }

       return null;
    }
}
