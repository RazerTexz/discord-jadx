package com.discord.utilities.press;

import android.view.MotionEvent;
import android.view.View;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: OnPressListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011B\u001d\b\u0016\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0010\u0010\u0014J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/discord/utilities/press/OnPressListener;", "Landroid/view/View$OnTouchListener;", "Landroid/view/MotionEvent;", "", "isPressed", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "Landroid/view/View;", "view", "event", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Lcom/discord/utilities/press/OnPressListener$OnPress;", "onPress", "Lcom/discord/utilities/press/OnPressListener$OnPress;", "pressed", "Z", "<init>", "(Lcom/discord/utilities/press/OnPressListener$OnPress;)V", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "OnPress", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class OnPressListener implements View.OnTouchListener {
    private final OnPress onPress;
    private boolean pressed;

    /* compiled from: OnPressListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/utilities/press/OnPressListener$1", "Lcom/discord/utilities/press/OnPressListener$OnPress;", "", "pressed", "", "onPress", "(Z)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.press.OnPressListener$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnPress {
        public final /* synthetic */ Function1 $onPress;

        public AnonymousClass1(Function1 function1) {
            this.$onPress = function1;
        }

        @Override // com.discord.utilities.press.OnPressListener.OnPress
        public void onPress(boolean pressed) {
            this.$onPress.invoke(Boolean.valueOf(pressed));
        }
    }

    /* compiled from: OnPressListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/press/OnPressListener$OnPress;", "", "", "pressed", "", "onPress", "(Z)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public interface OnPress {
        void onPress(boolean pressed);
    }

    public OnPressListener(OnPress onPress) {
        Intrinsics3.checkNotNullParameter(onPress, "onPress");
        this.onPress = onPress;
    }

    private final Boolean isPressed(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 && action != 3) {
                if (action != 5) {
                    if (action != 6) {
                        return null;
                    }
                }
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        boolean zBooleanValue;
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(event, "event");
        Boolean boolIsPressed = isPressed(event);
        if (boolIsPressed == null || this.pressed == (zBooleanValue = boolIsPressed.booleanValue())) {
            return false;
        }
        this.pressed = zBooleanValue;
        this.onPress.onPress(zBooleanValue);
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnPressListener(Function1<? super Boolean, Unit> function1) {
        this(new AnonymousClass1(function1));
        Intrinsics3.checkNotNullParameter(function1, "onPress");
    }
}
