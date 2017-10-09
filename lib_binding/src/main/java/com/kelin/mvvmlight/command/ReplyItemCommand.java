package com.kelin.mvvmlight.command;


import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BooleanSupplier;


/**
 * Created by kelin on 15-8-4.
 */
public class ReplyItemCommand<T1, T2> {


    private BiConsumer<T1, T2> execute2;

    private BooleanSupplier canExecute0;

    public ReplyItemCommand(BiConsumer<T1, T2> execute) {
        this.execute2 = execute;
    }

    public void execute(T1 params, T2 params2) {
        if (execute2 != null && canExecute0()) {
            try {
                execute2.accept(params, params2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean canExecute0() {
        if (canExecute0 == null) {
            return true;
        }
        try {
            return canExecute0.getAsBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
