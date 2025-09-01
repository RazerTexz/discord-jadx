package com.discord.utilities.view.validators;

import android.view.View;
import androidx.annotation.MainThread;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: ValidationManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cB-\b\u0016\u0012\"\u0010\u0019\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e0\u001d\"\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u001b\u0010\u001eJ\u0019\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\f\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u000b2\u001c\u0010\n\u001a\u0018\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0\u0006H\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0015\u0010\u0016RB\u0010\u0019\u001a.\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e0\u0017j\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/view/validators/ValidationManager;", "", "", "showErrors", "validate", "(Z)Z", "", "", "Lcom/discord/utilities/view/validators/FieldName;", "", "errorMap", "", "setErrors", "(Ljava/util/Map;)Ljava/util/Collection;", "Lcom/discord/utilities/view/validators/Input;", "Landroid/view/View;", "input", "", "addInput", "(Lcom/discord/utilities/view/validators/Input;)V", ModelAuditLogEntry.CHANGE_KEY_NAME, "removeInput", "(Ljava/lang/String;)V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "inputs", "Ljava/util/LinkedHashMap;", "<init>", "()V", "", "([Lcom/discord/utilities/view/validators/Input;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ValidationManager {
    private final LinkedHashMap<String, Input<? extends View>> inputs;

    public ValidationManager() {
        this.inputs = new LinkedHashMap<>();
    }

    public static /* synthetic */ boolean validate$default(ValidationManager validationManager, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return validationManager.validate(z2);
    }

    @MainThread
    public final void addInput(Input<? extends View> input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        this.inputs.put(input.getName(), input);
    }

    @MainThread
    public final void removeInput(String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.inputs.remove(name);
    }

    @MainThread
    public final Collection<String> setErrors(Map<String, ? extends List<String>> errorMap) {
        Intrinsics3.checkNotNullParameter(errorMap, "errorMap");
        ArrayList arrayList = new ArrayList();
        Collection<Input<? extends View>> collectionValues = this.inputs.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "inputs.values");
        for (Input input : _Collections.reversed(collectionValues)) {
            List<String> list = errorMap.get(input.getName());
            if (input.setErrorMessage(list != null ? (String) _Collections.firstOrNull((List) list) : null)) {
                arrayList.add(input.getName());
            }
        }
        return _Sets.minus((Set) errorMap.keySet(), (Iterable) arrayList);
    }

    @MainThread
    public final boolean validate(boolean showErrors) {
        boolean z2;
        Collection<Input<? extends View>> collectionValues = this.inputs.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "inputs.values");
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            while (it.hasNext()) {
                z2 = ((Input) it.next()).validate(showErrors) && z2;
            }
            return z2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ValidationManager(Input<? extends View>... inputArr) {
        this();
        Intrinsics3.checkNotNullParameter(inputArr, "inputs");
        LinkedHashMap<String, Input<? extends View>> linkedHashMap = this.inputs;
        for (Input<? extends View> input : inputArr) {
            linkedHashMap.put(input.getName(), input);
        }
    }
}
