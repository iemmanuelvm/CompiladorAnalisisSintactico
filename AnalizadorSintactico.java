/*
    EQUIPO
    ALUMNO: JUAN GERARDO BARRON HERNANDEZ MATRICULA: 33142377
    ALUMNO: EMMANUEL DE JESUS VELASQUEZ MARTINEZ MATRICULA: 35161479
*/
public class AnalizadorSintactico
{

public ErroresSintacticos error = new ErroresSintacticos();
public int RecorreTok, numtoken;
public String nombre="";
public int[] Clave;
public int[] Linea;

//RECIBE LO PARAMETROS PARA EL ANALIZADOR SINTACTICOS
public void RecibirArgumentos(int[] clave, int[] linea, int num, String Archivo)
{
      numtoken = num;
      nombre = Archivo;
      Clave = clave;
      Linea = linea;
}
/*Programa ::= Bloque.*/
public void Programa()
{
	   Bloque();      
   	if(Clave[RecorreTok] == 18)
      {
         RecorreTok++;
         if (RecorreTok == numtoken)
         {
               error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],1);
         }
         else
         {
               error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],2);
         }    
   	} 
      else
      {
         error.ImprimirError(nombre,Linea[RecorreTok-1],Clave[RecorreTok-1],3);
      }
}
/*<Bloque> ::= (const  <A> | Epsilon)  ( var  <B> | Epsilon )   <C>  <Proposición> */
public void Bloque()
{
		if (Clave[RecorreTok] == 1)
      {
         RecorreTok++;
      	A();
         if (Clave[RecorreTok] == 2)
         {
         	RecorreTok++;
         	B();
         }
   	} 
      else if (Clave[RecorreTok] == 2)
      {
      	RecorreTok++;
         B();
      }
      C();
      Proposicion();
}
/*<Condición> ::= <Expresión> <G>*/
public void Condicion()
{
   Expresion();
   G();
}
/*<Proposición> ::= begin <E> end | id= <Expresión> | write (id | num) | read id | call id | if <Condición> then <Proposición> | while <Condición> do <Proposición> | for id = <Expresión> (to | dto) <Expresión> do <Proposición>*/
public void Proposicion()
{
   if (Clave[RecorreTok] == 4)
   {
         RecorreTok++;
         E();
         if (Clave[RecorreTok] == 5)
         {
            RecorreTok++;
         }
         else 
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],12);
         }
   }
   else if (Clave[RecorreTok] == 16)
   {
         RecorreTok++;
         if (Clave[RecorreTok] == 19)
         {
            RecorreTok++;
            Expresion();
         }
         else 
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],5);
         }
   }
   else if (Clave[RecorreTok] == 7)
   {
         RecorreTok++;
         if (Clave[RecorreTok] == 16 || Clave[RecorreTok] == 17)
         {
            RecorreTok++;
         }
         else 
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],7);
         }
   }
   else if (Clave[RecorreTok] == 6)
   {
         RecorreTok++;
         if (Clave[RecorreTok] == 16)
         {
            RecorreTok++;
         }
         else 
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],6);
         }
   }
   else if (Clave[RecorreTok] == 8)
   {
         RecorreTok++;
         if (Clave[RecorreTok] == 16)
         {
            RecorreTok++;
         }
         else 
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],6);
         }
   }
   else if (Clave[RecorreTok] == 9)
   {
         RecorreTok++;
         Condicion();
         if (Clave[RecorreTok] == 10)
         {
            RecorreTok++;
            Proposicion();
         }
         else 
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],13);
         }
   }
   else if (Clave[RecorreTok] == 11)
   {
         RecorreTok++;
         Condicion();
         if (Clave[RecorreTok] == 12)
         {
            RecorreTok++;
            Proposicion();
         }
         else 
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],14);
         }
   }
   else if (Clave[RecorreTok] == 13)
   {
         RecorreTok++;
         if (Clave[RecorreTok] == 16)
         {
            RecorreTok++;
         }
         else 
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],6);
         }
         if (Clave[RecorreTok] == 19)
         {
            RecorreTok++;
            Expresion();
         }
         else
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],3);
         }
         if (Clave[RecorreTok] == 14 || Clave[RecorreTok] == 15)
         {
            RecorreTok++;
            Expresion();
         }
         else 
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],9);
         }
         if (Clave[RecorreTok] == 12)
         {
            RecorreTok++;
            Proposicion();
         }
         else
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],15);
         }
   }
   else 
   {
         error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],8);
   }
}
/*<Expresion> ::= <Termino> <I>*/
public void Expresion()
{
   Termino();
   I();
}
/*<Termino> ::= <Factor> <J>*/
public void Termino()
{
   Factor();
   J();
}
/*<Factor> ::=  ( <Expresión> ) | id | num*/
public void Factor()
{
      if (Clave[RecorreTok] == 22)
      {
         RecorreTok++;
         Expresion();
         if(Clave[RecorreTok] == 23)
         {
            RecorreTok++;
         }
         else
         {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],16);
         }
      }
      else if (Clave[RecorreTok] == 16 || Clave[RecorreTok] == 17)
      {
            RecorreTok++;
      }
      else
      {
            error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],7);
      }
}
/*<A> ::= id = num <D> */
public void A()
{
      if (Clave[RecorreTok] == 16)
      {
         RecorreTok++;
         if (Clave[RecorreTok] == 19)
         {
            RecorreTok++;
            if (Clave[RecorreTok] == 17)
            {
               RecorreTok++;
               D();
            }
            else
            {
               error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],10);
            }
         }
         else
         {
               error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],5);
         }
      }
      else
      {
               error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],6);
      }
}
/*<B> ::= id <F>*/
public void B()
{
   if (Clave[RecorreTok] == 16)
   {
         RecorreTok++;
         F();
   }
   else
   {
         error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],6);
   }
}
/*<C> ::= proced id; <Bloque> ; <C> | Epsilon*/
public void C()
{
      if (Clave[RecorreTok] == 3)
      {
         RecorreTok++;
         if (Clave[RecorreTok] == 16)
         {
            RecorreTok++;
            if (Clave[RecorreTok] == 21)
            {
               RecorreTok++;
               Bloque();
               if (Clave[RecorreTok] == 21)
               {
                  RecorreTok++;
                  C();
               }
               else 
               {
                  error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],4);
               }
            }
            else
            {
               error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],4);
            }
         }
         else 
         {
               error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],6);
         }
      }
}
/*<D> ::=   , <A> | ;*/
public void D()
{
   if (Clave[RecorreTok] == 20)
   {
         RecorreTok++;
   		A();
   }
   else if(Clave[RecorreTok] == 21)
   {
         RecorreTok++;
   }   
   else
   {
         error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],4);
   }
}
/*<E> ::= <Proposición> <H>*/
public void E()
{
   Proposicion();
   H();
}
/*<F> ::=   , <B> |  ;*/
public void F()
{
	if (Clave[RecorreTok] == 20)
   {
         RecorreTok++;
   		B();
   }
   else if(Clave[RecorreTok] == 21)
   {
         RecorreTok++;
   }
   else 
   {
         error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],4);
   }
}
/*<G> ::=  == <Expresión> | != <Expresión>  | < <Expresión> | > <Expresión> | <= <Expresión> | >= <Expresión> */
public void G()
{
   if (Clave[RecorreTok] == 24 || Clave[RecorreTok] == 25 || Clave[RecorreTok] == 26 || Clave[RecorreTok] == 27 || Clave[RecorreTok] == 28 || Clave[RecorreTok] == 29)
   {
         RecorreTok++;
   }
   else
   {
      error.ImprimirError(nombre,Linea[RecorreTok],Clave[RecorreTok],11);
   }
	Expresion();
}
/*<H> ::=  Epsilon | ; <E>*/
public void H()
{
	if (Clave[RecorreTok] == 21)
   {
         RecorreTok++;
   		E();
   }
}
/*<I> ::=  +<Expresión> | -<Expresión> | Epsilon */
public void I()
{
		if (Clave[RecorreTok] == 30 || Clave[RecorreTok] == 31)
      {
         RecorreTok++;
         Expresion();
     	}
}
/*<J> ::=  Epsilon  | *<Termino> | /<Termino>*/
public void J()
{
	   if (Clave[RecorreTok] == 32 || Clave[RecorreTok] == 33)
      {
         RecorreTok++;
         Termino();
     	}
}
}