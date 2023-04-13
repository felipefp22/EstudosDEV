//public class Calculos {
//    public static double IMC(DadosPessoais dadosPessoais)
//    {
//        return dadosPessoais.getAltura() / dadosPessoais.getPeso() / 10;
//    }
//
//    /* Equação Harris-Benedict revisada */
//    public double TMB(DadosPessoais dadosPessoais)
//    {
//        double gastoTMB;
//
//        if(dadosPessoais.getSexo().equals("Masculino"))
//        {
//            gastoTMB = 13.397 * dadosPessoais.getPeso() +
//                    4.799  * dadosPessoais.getAltura() -
//                    5.677  * dadosPessoais.getIdade() +
//                    88.362;
//        }
//        else
//        {
//            gastoTMB = 9.247 * dadosPessoais.getPeso() +
//                    3.098 * dadosPessoais.getAltura() -
//                    4.330 * dadosPessoais.getIdade() +
//                    447.593;
//        }
//
//        return gastoTMB;
//    }
//
//    public double caloriasDiarias(DadosPessoais dadosPessoais, double TMB)
//    {
//        int atividade = dadosPessoais.getFreqAtividade();
//        double qtdCalorias;
//
//        switch(atividade)
//        {
//            case 1:
//                qtdCalorias = TMB * 1.200; break;
//            case 2:
//                qtdCalorias = TMB * 1.375; break;
//            case 3:
//                qtdCalorias = TMB * 1.550; break;
//            case 4:
//                qtdCalorias = TMB * 1.725; break;
//            case 5:
//                qtdCalorias = TMB * 1.900; break;
//            default:
//                qtdCalorias = 0; break;
//        }
//
//        return qtdCalorias;
//    }
//
//    public static int qtdAguaDiaria(DadosPessoais dadosPessoais)
//    {
//        return (int)(35 * dadosPessoais.getPeso());
//    }
//}
