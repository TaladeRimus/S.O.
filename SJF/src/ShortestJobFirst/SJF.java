package ShortestJobFirst;

import java.util.Scanner;


/**
 * 
 * O SJF (Shortest Job First ou Processo mais curto primeiro) é um algoritmo de escalonamento que executa, dentre processos igualmente importantes, o mais curto primeiro.
 * 
 *
 */
 
public class SJF {
	
    public static void main(String args[])
    {
        int process[] = new int[10];
        int ptime[] = new int[10];
        int wtime[] = new int[10];
        int temp, n, total=0;
        float avg=0;
        Scanner get = new Scanner(System.in);
 
        System.out.println("Enter Number of Processes:");
        n = get.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Process "+(i+1)+" ID: ");
            process[i] = get.nextInt();
            System.out.println("Enter Process "+(i+1)+" Burst Time: ");
            ptime[i] = get.nextInt();
        }
        /**
         * 
         * O SJF verifica se o tempo no qual o processo fica em execucao
         * e maior que o proximo, se for, e executada a troca de processos 
         * Procurando o processo que tem o menor tempo de execucao
         * 
         * 
         */
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++) {              
            	
            	if(ptime[i]>ptime[j])
                {
                    temp = ptime[i];
                    ptime[i] = ptime[j];
                    ptime[j] = temp;
                    
                    temp = process[i];
                    process[i] = process[j];
                    process[j] = temp;
                }
            }
        }
 
        /**
         * 
         * Para o calculo do tempo de espera de cada processo
         * E feita uma soma com o tempo de espera atual
         * com o tempo de espera do processo anterios
         * 
         */
        wtime[0] = 0;
        for(int i=1;i<n;i++)
        {
            wtime[i] = wtime[i-1]+ptime[i-1];
            total = total + wtime[i];
        }
        
        //calculo do tempo medio de espera para cada processo
        avg = (float)total/n;
        
        
        //Mostra na tela todas as informacoes referentes a cada processo
        
        System.out.println("P_ID P_TIME W_TIME");
        for(int i=0;i<n;i++)
        {
            System.out.println(process[i]+"\t"+ptime[i]+"\t"+wtime[i]);
        }
        System.out.println("Total Waiting Time: "+total);
        System.out.println("Average Waiting Time: "+avg);
    }
}