package me.tomassetti.symbolsolver.resolution;

import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import me.tomassetti.symbolsolver.model.typesystem.ReferenceTypeUsage;
import me.tomassetti.symbolsolver.resolution.javaparser.JavaParserFacade;
import me.tomassetti.symbolsolver.javaparser.Navigator;
import me.tomassetti.symbolsolver.model.declarations.TypeDeclaration;
import me.tomassetti.symbolsolver.resolution.typesolvers.JreTypeSolver;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by federico on 22/08/15.
 */
public class JavaParserFacadeTest extends AbstractTest {

    @Test
    public void typeDeclarationSuperClassImplicitlyIncludeObject() throws ParseException {
        CompilationUnit cu = parseSample("Generics");
        ClassOrInterfaceDeclaration clazz = Navigator.demandClass(cu, "Generics");
        TypeDeclaration typeDeclaration = JavaParserFacade.get(new JreTypeSolver()).getTypeDeclaration(clazz);
        ReferenceTypeUsage superclass = typeDeclaration.asClass().getSuperClass(new JreTypeSolver());
        assertEquals(Object.class.getCanonicalName(), superclass.getQualifiedName());
    }
}
