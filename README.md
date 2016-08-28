# ruleMachine
A simple rule machine system

# Description
The Rule Machine implements the logic for create:
1. The context rule
2. The working memmory
3. The resolver

## Variables
All variables defined has the next
```java
...
    private Value value;
    private String label;
    private boolean negated;
    
    public Variable(String label, boolean negated) {
        this.value = Value.UNKNOWN; //Default value, later set this value
        this.label = label; //label name like 'A' or 'it is raining'
        this.negated = negated; //if the variable is negated then true, false in otherwise
    }
...
```

# Test
```java
    @Test
    public void contextTest() throws Exception {
        RuleMachine machine = new RuleMachine();
        machine.addRule(new RuleBuilder()
          .withName("Rule 1")
          .first(new Variable("A", false))
          .and(new Variable("B", true))
          .or(new Variable("C", false))
          .then(new Variable("D", true))
        );
      machine.setValueToVariable("D", Value.FALSE);
      
      System.out.println(machine.getVariable("D"));
      System.out.println(machine.getRules().get(0));
     }
```
The console must show
```
Variable{value=FALSE, label=D, negated=true}
Unknown name rule: A and ~B or C => ~D
```

# Next work
At the time I write this lines this project is at 10% af the spected result. If you want to help me, welcome!
