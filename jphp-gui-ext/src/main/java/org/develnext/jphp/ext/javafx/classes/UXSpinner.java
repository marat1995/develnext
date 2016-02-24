package org.develnext.jphp.ext.javafx.classes;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import org.develnext.jphp.ext.javafx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.reflection.ClassEntity;

@Reflection.Name(JavaFXExtension.NS + "UXSpinner")
public class UXSpinner extends UXControl<Spinner> {
    interface WrappedInterface {
        @Property boolean editable();
        @Property TextField editor();
    }

    public UXSpinner(Environment env, Spinner wrappedObject) {
        super(env, wrappedObject);
    }

    public UXSpinner(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new Spinner<>();
    }

    @Signature
    public void setValueFactory(@Reflection.Nullable final Invoker increment, @Reflection.Nullable final Invoker decrement) {
        getWrappedObject().setValueFactory(new SpinnerValueFactory() {
            @Override
            public void decrement(int steps) {
                if (decrement != null) {
                    decrement.callAny(this, steps);
                }
            }

            @Override
            public void increment(int steps) {
                if (increment != null) {
                    increment.callAny(this, steps);
                }
            }
        });
    }

    @Signature
    public void setIntegerValueFactory() {
        setIntegerValueFactory(Integer.MIN_VALUE);
    }

    @Signature
    public void setIntegerValueFactory(int min) {
        setIntegerValueFactory(min, Integer.MAX_VALUE);
    }

    @Signature
    public void setIntegerValueFactory(int min, int max) {
        setIntegerValueFactory(min, max, min);
    }

    @Signature
    public void setIntegerValueFactory(int min, int max, int initial) {
        setIntegerValueFactory(min, max, initial, 1);
    }

    @Signature
    public void setIntegerValueFactory(int min, int max, int initial, int step) {
        getWrappedObject().setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, initial, step));
    }
}
