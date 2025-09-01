package com.discord.app;

import android.content.Context;
import androidx.annotation.AnimRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import com.discord.R;
import com.discord.utilities.accessibility.AccessibilityUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: AppTransitionActivity.kt */
/* loaded from: classes.dex */
public abstract class AppTransitionActivity extends AppCompatActivity {
    public static boolean j;
    public a k = Transition.TYPE_SLIDE_POP_VERTICAL.getAnimations();

    /* compiled from: AppTransitionActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/discord/app/AppTransitionActivity$Transition;", "", "Landroid/content/Context;", "context", "Landroidx/core/app/ActivityOptionsCompat;", "toActivityOptions", "(Landroid/content/Context;)Landroidx/core/app/ActivityOptionsCompat;", "Lcom/discord/app/AppTransitionActivity$a;", "animations", "Lcom/discord/app/AppTransitionActivity$a;", "getAnimations", "()Lcom/discord/app/AppTransitionActivity$a;", "<init>", "(Ljava/lang/String;ILcom/discord/app/AppTransitionActivity$a;)V", "TYPE_FADE", "TYPE_FADE_FAST", "TYPE_STANDARD", "TYPE_SLIDE_HORIZONTAL", "TYPE_SLIDE_HORIZONTAL_REVERSE", "TYPE_SLIDE_VERTICAL", "TYPE_SLIDE_VERTICAL_WITH_FADE", "TYPE_SLIDE_POP_VERTICAL", "TYPE_SLIDE_POP_HORIZONTAL", "TYPE_NONE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum Transition {
        TYPE_FADE(new a(R.anim.activity_fade_open_in, R.anim.activity_fade_open_out, R.anim.activity_fade_close_in, R.anim.activity_fade_close_out)),
        TYPE_FADE_FAST(new a(R.anim.activity_fade_open_in_fast, R.anim.activity_fade_open_out_fast, R.anim.activity_fade_close_in_fast, R.anim.activity_fade_close_out_fast)),
        TYPE_STANDARD(new a(R.anim.activity_standard_open_in, R.anim.activity_standard_open_out, R.anim.activity_standard_close_in, R.anim.activity_standard_close_out)),
        TYPE_SLIDE_HORIZONTAL(new a(R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_open_out, R.anim.activity_slide_horizontal_close_in, R.anim.activity_slide_horizontal_close_out)),
        TYPE_SLIDE_HORIZONTAL_REVERSE(new a(R.anim.activity_slide_horizontal_close_in, R.anim.activity_slide_horizontal_close_out, R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_open_out)),
        TYPE_SLIDE_VERTICAL(new a(R.anim.activity_slide_vertical_open_in, R.anim.activity_slide_vertical_open_out, R.anim.activity_slide_vertical_close_in, R.anim.activity_slide_vertical_close_out)),
        TYPE_SLIDE_VERTICAL_WITH_FADE(new a(R.anim.activity_slide_vertical_open_in, R.anim.activity_fade_open_out, R.anim.activity_fade_close_in, R.anim.activity_slide_vertical_close_out)),
        TYPE_SLIDE_POP_VERTICAL(new a(R.anim.activity_slide_pop_vertical_open_in, R.anim.activity_slide_pop_vertical_open_out, R.anim.activity_slide_pop_vertical_close_in, R.anim.activity_slide_pop_vertical_close_out)),
        TYPE_SLIDE_POP_HORIZONTAL(new a(R.anim.activity_slide_pop_horizontal_open_in, R.anim.activity_slide_pop_horizontal_open_out, R.anim.activity_slide_pop_horizontal_close_in, R.anim.activity_slide_pop_horizontal_close_out)),
        TYPE_NONE(new a(0, 0, 0, 0));

        private final a animations;

        Transition(a aVar) {
            this.animations = aVar;
        }

        public final a getAnimations() {
            return this.animations;
        }

        public final ActivityOptionsCompat toActivityOptions(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            if ((!AccessibilityUtils.INSTANCE.isReducedMotionEnabled() ? this : null) == null) {
                return null;
            }
            a aVar = this.animations;
            return ActivityOptionsCompat.makeCustomAnimation(context, aVar.a, aVar.f2082b);
        }
    }

    /* compiled from: AppTransitionActivity.kt */
    public static final class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2082b;
        public final int c;
        public final int d;

        public a(@AnimRes int i, @AnimRes int i2, @AnimRes int i3, @AnimRes int i4) {
            this.a = i;
            this.f2082b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public final void a(boolean z2, boolean z3) {
        a aVar;
        if (z2 && z3) {
            return;
        }
        if ((z2 || z3) && (aVar = this.k) != null) {
            overridePendingTransition(z3 ? aVar.a : aVar.c, z3 ? aVar.f2082b : aVar.d);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        j = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a(j, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a(j, true);
        j = false;
    }
}
