import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

class Main {

    static BufferedReader in;
    static PrintWriter out;

    static final String[] OUTPUT = new String[]{
            "123153452",
            "123154352",
            "123451352",
            "123453152",
            "123513452",
            "123543152",
            "125134532",
            "125135432",
            "125315432",
            "125345132",
            "125431532",
            "125435132",
            "132153452",
            "132154352",
            "132534512",
            "132543512",
            "134512352",
            "134512532",
            "134521532",
            "134523512",
            "134532152",
            "134532512",
            "135123452",
            "135125432",
            "135215432",
            "135234512",
            "135432152",
            "135432512",
            "152134532",
            "152135432",
            "152345312",
            "152354312",
            "153123452",
            "153125432",
            "153213452",
            "153254312",
            "153452132",
            "153452312",
            "154312352",
            "154312532",
            "154321352",
            "154325312",
            "154352132",
            "154352312",
    };

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));

        for (String s : OUTPUT) {
            out.println(s);
        }
        
        out.flush();
    }

}
