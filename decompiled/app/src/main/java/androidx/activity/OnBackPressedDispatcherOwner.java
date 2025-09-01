package androidx.activity;

import androidx.annotation.NonNull;
import androidx.view.LifecycleOwner;

/* loaded from: classes.dex */
public interface OnBackPressedDispatcherOwner extends LifecycleOwner {
    @NonNull
    OnBackPressedDispatcher getOnBackPressedDispatcher();
}
