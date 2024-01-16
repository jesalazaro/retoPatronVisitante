
class BuilderFactory {
  public UIBuilder getUIBuilder(String str) {

    UIBuilder builder = null;
    if (str.equals(OrderManager.NON_CA_ORDER)){
        builder = new NonCaliforniaBuilder();
        return builder;
    }else if(str.equals(OrderManager.CA_ORDER)){
        builder = new CaliforniaBuilder();
        return builder;
    }else if(str.equals(OrderManager.OVERSEAS_ORDER)){
        builder = new OverseasBuilder();
        return builder;
    }else if(str.equals(OrderManager.BRAZILIAN_ORDER)){
        builder = new BrazilianBuilder();
        return builder;
    }else{
        return builder;
    }
  }
}