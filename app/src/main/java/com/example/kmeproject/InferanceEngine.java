package com.example.kmeproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InferanceEngine {


    public static String getCategory(ArrayList<String> lines, ArrayList<String> elementsOfDesign, ArrayList<String> colors, ArrayList<String> budget) {

       if(lines.contains(Constants.STRAIGHT_LINES) &&
               elementsOfDesign.contains(Constants.SIMPLE)
               && budget.contains(Constants.AVERAGE) ||
               budget.contains(Constants.LOW) ||
               budget.contains(Constants.HIGH)) {
           return Constants.MODERN_MINIMALIST;

       }else if (budget.contains(Constants.LOW) && elementsOfDesign.contains(Constants.SUPER_SIMPLE)) {
       	   return Constants.MINIMALIST;
       }else if ((colors.contains(Constants.MID_TONE) || colors.contains(Constants.DARK) )
               && budget.contains(Constants.HIGH) &&( elementsOfDesign.contains(Constants.DETAILED) || lines.contains(Constants.CURVED_LINES))) {
       	  return Constants.CLASSIC;
       }else if (elementsOfDesign.contains(Constants.SIMPLE) && budget.contains(Constants.AVERAGE)){
       	  return Constants.MODERNIST;
       }else if (elementsOfDesign.contains(Constants.DETAILED)|| elementsOfDesign.contains(Constants.MID_RANGE) && lines.contains(Constants.CURVED_WITH_STRAIGHT)  ){
       	  return Constants.CLASSIC_MODERN;
   	   }else if (budget.contains(Constants.AVERAGE) || elementsOfDesign.contains(Constants.SUPER_SIMPLE) || elementsOfDesign.contains(Constants.SIMPLE)) {
   	   	  return Constants.MINIMALIST;
   	   }else if (elementsOfDesign.contains(Constants.SIMPLE) && lines.contains(Constants.STRAIGHT_LINES)){
   	   	 if(budget.contains(Constants.LOW) || budget.contains(Constants.HIGH) ){
   	   	 	return Constants.MODERN_MINIMALIST;
   	   	 }
   	   	 return Constants.MODERNIST;
   	   }else{
           return Constants.CLASSIC;
       }


    }
}
