package foo.bar;


import org.apache.commons.io.IOUtils;
import org.asciidoctor.Asciidoctor;
import org.jruby.Ruby;
import org.jruby.javasupport.JavaEmbedUtils;
import org.jruby.runtime.builtin.IRubyObject;
import org.junit.Test;

import java.util.Collections;

public class JRubyTest {


    @Test
    public void basicTest() throws Exception {

        final Ruby rubyRuntime = JavaEmbedUtils.initialize(Collections.EMPTY_LIST);

        final String script = IOUtils.toString(getClass().getResourceAsStream("/test.rb"), "UTF-8");
        rubyRuntime.evalScriptlet(script);
        IRubyObject rubyTestImpl = JavaEmbedUtils.newRuntimeAdapter().eval(rubyRuntime, "TestImpl.new()");
        TestIntf javaTestImpl = (TestIntf) JavaEmbedUtils.rubyToJava(rubyRuntime, rubyTestImpl, TestIntf.class);

        System.out.println(javaTestImpl.sayHello());
    }

    @Test
    public void asciidoctorTest() {
        final Asciidoctor asciidoctor = Asciidoctor.Factory.create();

    }

}
