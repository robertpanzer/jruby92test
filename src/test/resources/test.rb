require 'java'

class TestImpl
    java_implements Java::foo::bar::TestIntf

    def say_hello
      return "Hello World"
    end

end