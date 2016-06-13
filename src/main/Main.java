package main;

import com.microsoft.z3.Status;
import generator.VCGen;
import instrs.*;
import operator.Exp;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import parser.*;
import prover.Prover;
import prover.Result;
import visitor.Visitor;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws IOException {

        final JFileChooser fc = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));

        fc.setCurrentDirectory(workingDirectory);

        int ret = fc.showSaveDialog(null);

        if(ret == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getAbsolutePath();

            ANTLRInputStream in = new ANTLRInputStream(new FileInputStream(new File(path)));
            GramaticaLexer lexer  = new GramaticaLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            GramaticaParser parser = new GramaticaParser(tokens);

            ParseTree tree = parser.programa();

            if(tree != null){
                Programa p =(Programa)(new Visitor().visit(tree)).getValue();

                ArrayList<Exp> condicoes = new VCGen().vcg(p);

                Prover prover = new Prover(condicoes);

                ArrayList<Result> results = prover.parse();

                printResults(results);
            }
        }
    }

    private static void printResults(ArrayList<Result> results){

        int i=1;
        boolean f = true;

        for(Result r : results){
            if(r.getStat() == Status.SATISFIABLE){
                f = false;
            }
            System.out.println("VC" + i + ": " + r.getCondicao());
            System.out.println("\tZ3: (assert (not(" + r.getZ3() + ")))");
            System.out.println("\tResult: " + r.getStat());
            i++;
            System.out.println();
        }

        System.out.print("O programa " + (f ? "é" : "não é") + " válido");
    }
}
