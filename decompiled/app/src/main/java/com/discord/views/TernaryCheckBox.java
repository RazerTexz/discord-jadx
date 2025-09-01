package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import b.a.d.AppToast;
import b.a.i.ViewTernaryCheckboxBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TernaryCheckBox.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00027\rB\u001b\b\u0016\u0012\u0006\u00101\u001a\u000200\u0012\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\tJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\tJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0005\u0010\u0011J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0007\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\tJ\u0017\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0017\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u0011R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00068"}, d2 = {"Lcom/discord/views/TernaryCheckBox;", "Landroid/widget/RelativeLayout;", "", "message", "", "setOffDisabled", "(Ljava/lang/String;)V", "setDisabled", "f", "()V", "e", "d", "", "b", "()Z", "", "messageRes", "(I)V", "c", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "setLabel", "(Ljava/lang/CharSequence;)V", "setSubtext", "m", "Ljava/lang/CharSequence;", "subtextText", "switchStatus", "o", "I", "getSwitchStatus", "()I", "setSwitchStatus", "Lb/a/i/a4;", "k", "Lb/a/i/a4;", "binding", "l", "Ljava/lang/String;", "labelText", "Lcom/discord/views/TernaryCheckBox$b;", "n", "Lcom/discord/views/TernaryCheckBox$b;", "getOnSwitchStatusChangedListener", "()Lcom/discord/views/TernaryCheckBox$b;", "setOnSwitchStatusChangedListener", "(Lcom/discord/views/TernaryCheckBox$b;)V", "onSwitchStatusChangedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "j", "a", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TernaryCheckBox extends RelativeLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewTernaryCheckboxBinding binding;

    /* renamed from: l, reason: from kotlin metadata */
    public String labelText;

    /* renamed from: m, reason: from kotlin metadata */
    public CharSequence subtextText;

    /* renamed from: n, reason: from kotlin metadata */
    public b onSwitchStatusChangedListener;

    /* renamed from: o, reason: from kotlin metadata */
    public int switchStatus;

    /* compiled from: TernaryCheckBox.kt */
    /* renamed from: com.discord.views.TernaryCheckBox$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: TernaryCheckBox.kt */
    public interface b {
        void onSwitchStatusChanged(int i);
    }

    /* compiled from: TernaryCheckBox.kt */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ String k;

        public c(String str) {
            this.k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppToast.h(TernaryCheckBox.this.getContext(), this.k, 0, null, 12);
        }
    }

    /* compiled from: TernaryCheckBox.kt */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ String k;

        public d(String str) {
            this.k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppToast.h(TernaryCheckBox.this.getContext(), this.k, 0, null, 12);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TernaryCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_ternary_checkbox, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.checkable_off_container;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.checkable_off_container);
        if (frameLayout != null) {
            i = R.id.checkboxes_container;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.checkboxes_container);
            if (linearLayout != null) {
                i = R.id.off_disabled_overlay;
                View viewFindViewById = viewInflate.findViewById(R.id.off_disabled_overlay);
                if (viewFindViewById != null) {
                    i = R.id.setting_disabled_overlay;
                    View viewFindViewById2 = viewInflate.findViewById(R.id.setting_disabled_overlay);
                    if (viewFindViewById2 != null) {
                        i = R.id.setting_label;
                        TextView textView = (TextView) viewInflate.findViewById(R.id.setting_label);
                        if (textView != null) {
                            i = R.id.setting_subtext;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R.id.setting_subtext);
                            if (linkifiedTextView != null) {
                                i = R.id.ternary_check_neutral;
                                CheckableImageView checkableImageView = (CheckableImageView) viewInflate.findViewById(R.id.ternary_check_neutral);
                                if (checkableImageView != null) {
                                    i = R.id.ternary_check_off;
                                    CheckableImageView checkableImageView2 = (CheckableImageView) viewInflate.findViewById(R.id.ternary_check_off);
                                    if (checkableImageView2 != null) {
                                        i = R.id.ternary_check_on;
                                        CheckableImageView checkableImageView3 = (CheckableImageView) viewInflate.findViewById(R.id.ternary_check_on);
                                        if (checkableImageView3 != null) {
                                            ViewTernaryCheckboxBinding viewTernaryCheckboxBinding = new ViewTernaryCheckboxBinding((LinearLayout) viewInflate, frameLayout, linearLayout, viewFindViewById, viewFindViewById2, textView, linkifiedTextView, checkableImageView, checkableImageView2, checkableImageView3);
                                            Intrinsics3.checkNotNullExpressionValue(viewTernaryCheckboxBinding, "ViewTernaryCheckboxBindi…rom(context), this, true)");
                                            this.binding = viewTernaryCheckboxBinding;
                                            this.switchStatus = -1;
                                            if (attributeSet != null) {
                                                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.TernaryCheckBox, 0, 0);
                                                Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.TernaryCheckBox, 0, 0)");
                                                try {
                                                    this.labelText = typedArrayObtainStyledAttributes.getString(0);
                                                    String string = typedArrayObtainStyledAttributes.getString(1);
                                                    this.subtextText = string != null ? FormatUtils.l(string, new Object[0], null, 2) : null;
                                                } finally {
                                                    typedArrayObtainStyledAttributes.recycle();
                                                }
                                            }
                                            Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingLabel");
                                            textView.setVisibility(this.labelText != null ? 0 : 8);
                                            Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingLabel");
                                            textView.setText(this.labelText);
                                            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
                                            linkifiedTextView.setVisibility(this.subtextText != null ? 0 : 8);
                                            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
                                            linkifiedTextView.setText(this.subtextText);
                                            checkableImageView3.setOnClickListener(new defpackage.c(0, this));
                                            checkableImageView2.setOnClickListener(new defpackage.c(1, this));
                                            checkableImageView.setOnClickListener(new defpackage.c(2, this));
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void a(TernaryCheckBox ternaryCheckBox, int i) {
        ternaryCheckBox.setSwitchStatus(i);
    }

    private final void setDisabled(String message) {
        FrameLayout frameLayout = this.binding.f77b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.checkableOffContainer");
        frameLayout.setEnabled(true);
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.offDisabledOverlay");
        view.setVisibility(8);
        this.binding.d.setOnClickListener(new c(message));
        View view2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.settingDisabledOverlay");
        view2.setVisibility(0);
    }

    private final void setOffDisabled(String message) {
        CheckableImageView checkableImageView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOff");
        checkableImageView.setEnabled(false);
        View view = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.settingDisabledOverlay");
        view.setVisibility(8);
        this.binding.c.setOnClickListener(new d(message));
        View view2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.offDisabledOverlay");
        view2.setVisibility(0);
    }

    private final void setSwitchStatus(int i) {
        this.switchStatus = i;
        CheckableImageView checkableImageView = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOn");
        checkableImageView.setChecked(i == 1);
        CheckableImageView checkableImageView2 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(checkableImageView2, "binding.ternaryCheckOff");
        checkableImageView2.setChecked(i == -1);
        CheckableImageView checkableImageView3 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(checkableImageView3, "binding.ternaryCheckNeutral");
        checkableImageView3.setChecked(i == 0);
        b bVar = this.onSwitchStatusChangedListener;
        if (bVar != null) {
            bVar.onSwitchStatusChanged(i);
        }
    }

    public final boolean b() {
        return this.switchStatus == 1;
    }

    public final void c() {
        CheckableImageView checkableImageView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOff");
        checkableImageView.setEnabled(true);
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.offDisabledOverlay");
        view.setVisibility(8);
        View view2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.settingDisabledOverlay");
        view2.setVisibility(8);
    }

    public final void d() {
        setSwitchStatus(0);
    }

    public final void e() {
        setSwitchStatus(-1);
    }

    public final void f() {
        setSwitchStatus(1);
    }

    public final b getOnSwitchStatusChangedListener() {
        return this.onSwitchStatusChangedListener;
    }

    public final int getSwitchStatus() {
        return this.switchStatus;
    }

    public final void setLabel(CharSequence text) {
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingLabel");
        textView.setText(text);
    }

    public final void setOnSwitchStatusChangedListener(b bVar) {
        this.onSwitchStatusChangedListener = bVar;
    }

    public final void setSubtext(CharSequence text) {
        LinkifiedTextView linkifiedTextView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
        linkifiedTextView.setText(text);
    }

    public final void setDisabled(int messageRes) {
        String string = getContext().getString(messageRes);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(messageRes)");
        setDisabled(string);
    }

    public final void setOffDisabled(int messageRes) {
        String string = getContext().getString(messageRes);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(messageRes)");
        setOffDisabled(string);
    }
}
