package victor.training.cleancode;

import victor.training.cleancode.pretend.Autowired;
import victor.training.cleancode.pretend.Service;

import java.util.ArrayList;
import java.util.List;

public class ManyParamsOOP {
    @Autowired
    private OtherDependency dep;
//    @Autowired
//    private Validator validator;

    public void bizLogic() {
        Validator validator = new Validator(dep);
        validator.m1("a",1);
        validator.m2("b",1);
        validator.m3("file.txt", 1L,"ref");
        validator.m4("a", 1L,5L, "g");
        validator.m5(1);

        List<String> errors = validator.getErrors();
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }
    }
}
//@Service cannot be // avoid: @Scope("prototype") + @Autowire ObjectFactory<Validator> !!!
class Validator {
    List<String> errors = new ArrayList<>();

//    public Validator(List<String> errors) {
//        this.errors = errors;
//    }

//    @Autowired
	private final OtherDependency dep;

    Validator(OtherDependency dep) {
        this.dep = dep;
    }


    public List<String> getErrors() {
        return errors;
    }

    public void m1(String a, int b) {
        if (a == null) {
            errors.add("a must not be null");
        }
        // stuff
    }
    public void m2(String s, int c) {
        if (c < 0) {
            errors.add("negative c");
        }
        // stuff
    }
    public void m3(String fileName, long versionId, String reference) {
        // stuff
    }
    public void m4(String a, long listId, long recordId, String g) {
        // stuff
    }
    public void m5(int b) {
        // stuff
    }
}

@Service
class OtherDependency {

}
