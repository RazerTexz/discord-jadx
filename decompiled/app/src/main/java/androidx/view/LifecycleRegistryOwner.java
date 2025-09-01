package androidx.view;

import androidx.annotation.NonNull;

@Deprecated
/* loaded from: classes.dex */
public interface LifecycleRegistryOwner extends LifecycleOwner {
    @Override // androidx.view.LifecycleOwner
    @NonNull
    LifecycleRegistry getLifecycle();
}
