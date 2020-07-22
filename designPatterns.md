## Creational Patterns
    -Deal with the creation (construction) of objects
    -Explicit (constructor) vs. implicit (DI, refelection, etc.)
    -Wholesale (single statement) vs piecewise (step-by-step)
#### Builder Patterns
    When piecewise object construction is complicated,
      provide an API for doing it succinctly
#### Factory  Patterns
    Factory: A component responsible solely
             for the wholesale (not piecewise)
             creation of objects.

             Object creation logic sometimes too complicated
             Constructor sometimes not descriptive enough

    -- Abstract Factory
    -- Factory Method
#### Prototype
    All about object copying.
    
    "When it's easier to copy an existing object 
    rather than fully initializing a new one."
    
    Complicated objects (eg., cars, phones) aren't designed from scratch.
    
    "A partially or fully initialized object that
    you copy (clone) and make use of."
    
    1. Don't use Cloneable
            -only a marker interface
            -doesn't say anything about deep or shallow clone
            -doesn't say what should be in clone()
    2. Copy constructors
        
    3. Copy thru serialization

#### Singleton


## Behavioral
    -They're all different; no central theme
#### Chain of Responsibility
#### Command
#### Interpreter
#### Iterator
#### Mediator
#### Memento
#### Null Object
#### Observer
#### State
#### Strategy
#### Template Method
#### Visitor


## Structural
    -Concerned with the structure (e.g., class members)
    -Many patterns are wrappers that mimic underlying class' interface
    -Stress the importance of good API design
#### Adapter
#### Bridge
#### Composite
#### Decorator
#### Facade
#### Flyweight
#### Proxy

