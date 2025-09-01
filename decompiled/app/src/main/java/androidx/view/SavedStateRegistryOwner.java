package androidx.view;

import androidx.annotation.NonNull;
import androidx.view.LifecycleOwner;

/* loaded from: classes.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    @NonNull
    SavedStateRegistry getSavedStateRegistry();
}
