package br.com.matcomp.enums;
public enum MethodEnum {
	NENHUM(0),
	GAUSS(1), 
	JACOBI(2), 
	GAUSS_SEIDEL(3), 
	NEWTON_RAPHSON(4), 
	LEAST_SQUARES(5),
	NAO_ENCONTRADO(6);
	
    private int value; 
    private static MethodEnum[] values = null;
    
    private MethodEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }    
    
    public static MethodEnum fromInt(int value) {
        if(MethodEnum.values == null) {
        	MethodEnum.values = MethodEnum.values();
        }
        
        if(value == NENHUM.getValue()) return NENHUM;
        
        if(value < GAUSS.getValue() || value > LEAST_SQUARES.getValue()){
        	return NAO_ENCONTRADO;
        }
        
        return MethodEnum.values[value];
	}
  }