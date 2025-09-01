package com.discord.views;

import android.widget.Checkable;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: RadioManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\n\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/views/RadioManager;", "", "Landroid/widget/Checkable;", "targetButton", "", "a", "(Landroid/widget/Checkable;)V", "", "b", "()I", "checkedButtonIndex", "", "Ljava/util/List;", "buttons", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RadioManager {

    /* renamed from: a, reason: from kotlin metadata */
    public final List<Checkable> buttons;

    /* JADX WARN: Multi-variable type inference failed */
    public RadioManager(List<? extends Checkable> list) {
        Intrinsics3.checkNotNullParameter(list, "buttons");
        this.buttons = list;
        boolean z2 = false;
        for (Checkable checkable : list) {
            if (!z2 && checkable.isChecked()) {
                z2 = true;
            }
            checkable.setChecked(false);
        }
        if (z2) {
            return;
        }
        this.buttons.get(0).setChecked(true);
    }

    public final void a(Checkable targetButton) {
        Intrinsics3.checkNotNullParameter(targetButton, "targetButton");
        for (Checkable checkable : this.buttons) {
            checkable.setChecked(Intrinsics3.areEqual(checkable, targetButton));
        }
    }

    public final int b() {
        Iterator<Checkable> it = this.buttons.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isChecked()) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
