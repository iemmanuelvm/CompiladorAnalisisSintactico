/*
    EQUIPO
    ALUMNO: JUAN GERARDO BARRON HERNANDEZ MATRICULA: 33142377
    ALUMNO: EMMANUEL DE JESUS VELASQUEZ MARTINEZ MATRICULA: 35161479
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class ImprimirTokens
{
	public AnalisisLexico Lexico = new AnalisisLexico();
	public AnalizadorSintactico Sintactico = new AnalizadorSintactico();
	public Tabla TabSimbolos = new Tabla();
	public String cadena;
    public int indexError, PosicionError, NumeroTokens=0;
    public int[] Clave;
    public int[] Linea;
    public int getNumToken()
	{
		return NumeroTokens;
	}
    //METODO PARA IMPRIMIR ERRORES SI LOS HAY O IMPRIMIR LOS RESULTADOS
	public void Imprimir(ArrayList<String> LineasArchivo, String NombreFichero)
		{		
			TabSimbolos.TablaDeSimbolos();
			Lexico.RecibirArchivo(LineasArchivo);
			int NumTablaSimbolos;
			ArrayList<Integer> ClavesTokens=new ArrayList<Integer>();
  			Clave = new int[300];
  			Linea = new int[300];
			//System.out.println("#TOKEN\t\tLEXEMA");
			while(true)
				{
				NumTablaSimbolos = Lexico.AnalizadorLexico();
				if(NumTablaSimbolos==-1)
				{
					PosicionError = Lexico.getLinea()+1;
					System.out.println(NombreFichero+": ERROR EN LA L\u00cdNEA "+PosicionError+" : N\u00daMERO ENTERO NO V\u00c1LIDO");
					System.out.println(""+LineasArchivo.get(Lexico.getLinea()));
					cadena = LineasArchivo.get(Lexico.getLinea());
    				indexError = cadena.indexOf(Lexico.getTokenInvalido()); 
    				//FOR QUE QUE DICE DONDE EMPIEZA EL ERROR DEL TOKEN INVALIDO
    				for (int j=0; j<indexError; j++) 
    				{
    					System.out.print(" ");
    				}
    					System.out.print("^");
					break;
				}
				else if(NumTablaSimbolos==-2)
				{
					PosicionError = Lexico.getLinea()+1;
					System.out.println(NombreFichero+": ERROR EN LA L\u00cdNEA "+PosicionError+" : IDENTIFICADOR NO V\u00c1LIDO");
					System.out.println(""+LineasArchivo.get(Lexico.getLinea()));
					cadena = LineasArchivo.get(Lexico.getLinea());
    				indexError = cadena.indexOf(Lexico.getTokenInvalido()); 
    				//FOR QUE QUE DICE DONDE EMPIEZA EL ERROR DEL TOKEN INVALIDO
    				for (int j=0; j<indexError; j++) 
    				{
    					System.out.print(" ");
    				}
    					System.out.print("^");
					break;
				}
				else if(NumTablaSimbolos==-3)
				{
					PosicionError = Lexico.getLinea()+1;
					System.out.println(NombreFichero+": ERROR EN LA L\u00cdNEA "+PosicionError+" : ELEMENTO INVALIDO");
					System.out.println(""+LineasArchivo.get(Lexico.getLinea()));
					cadena = LineasArchivo.get(Lexico.getLinea());
    				indexError = cadena.indexOf(Lexico.getTokenInvalido()); 
    				//FOR QUE QUE DICE DONDE EMPIEZA EL ERROR DEL TOKEN INVALIDO
    				for (int j=0; j<indexError; j++) 
    				{
    					System.out.print(" ");
    				}
    					System.out.print("^");					
					break;
				}
				else if(NumTablaSimbolos==-4)
				{	
					String Fichero = NombreFichero;
					/*System.out.println("Claves");
					for(int j=0;j<ClaveToken.size();j++)
					{
						System.out.print(ClaveToken.get(j)+" ");
					}
					System.out.println("No de linea");
					for(int j=0;j<LineaToken.size();j++)
					{
						System.out.print(LineaToken.get(j)+" ");
					}
					System.out.println("Elementos"+ClaveToken.size() + " " + LineaToken.size());*/
					Sintactico.RecibirArgumentos(Clave,Linea,NumeroTokens,Fichero);
					Sintactico.Programa();
					break;
				}
				else
				{
					//AQUI SE EMPRIME LOS LEXEMAS QUE NO ESTEN DENTRO DE LA TABLA DE SIMBOLOS
					if(TabSimbolos.RetornoDelToken(NumTablaSimbolos).equals("identificador"))
					{
						//System.out.println(NumTablaSimbolos+"\t\t"+Lexico.getLexema());
						Clave[NumeroTokens]=NumTablaSimbolos;
						Linea[NumeroTokens]=Lexico.getLinea()+1;
      					NumeroTokens++;
					}
					else if(TabSimbolos.RetornoDelToken(NumTablaSimbolos).equals("entero"))
					{
						//System.out.println(NumTablaSimbolos+"\t\t"+Lexico.getLexema());
						Clave[NumeroTokens]=NumTablaSimbolos;
						Linea[NumeroTokens]=Lexico.getLinea()+1;
      					NumeroTokens++;
					}
					else
					{
						//System.out.println(NumTablaSimbolos);
						Clave[NumeroTokens]=NumTablaSimbolos;
						Linea[NumeroTokens]=Lexico.getLinea()+1;
      					NumeroTokens++;
					}
				}
			}
	}  
}