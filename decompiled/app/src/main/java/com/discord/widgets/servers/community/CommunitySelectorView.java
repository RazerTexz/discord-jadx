package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.ViewServerSettingsCommunitySettingSelectorBinding;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CommunitySelectorView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/servers/community/CommunitySelectorView;", "Landroid/widget/LinearLayout;", "Landroid/util/AttributeSet;", "attrs", "", "initAttrs", "(Landroid/util/AttributeSet;)V", "", "subtitle", "setSubtitle", "(Ljava/lang/CharSequence;)V", "Lcom/discord/databinding/ViewServerSettingsCommunitySettingSelectorBinding;", "binding", "Lcom/discord/databinding/ViewServerSettingsCommunitySettingSelectorBinding;", "Landroid/content/Context;", "context", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CommunitySelectorView extends LinearLayout {
    private final ViewServerSettingsCommunitySettingSelectorBinding binding;

    public CommunitySelectorView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CommunitySelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ CommunitySelectorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initAttrs(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.a.CommunitySelectorView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…munitySelectorView, 0, 0)");
        CharSequence text = typedArrayObtainStyledAttributes.getText(3);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(2);
        CharSequence text3 = typedArrayObtainStyledAttributes.getText(0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(1, true);
        typedArrayObtainStyledAttributes.recycle();
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsCo…unitySettingSelectorTitle");
        textView.setText(text);
        TextView textView2 = this.binding.f2208b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsCo…ettingSelectorDescription");
        textView2.setText(text3);
        TextView textView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsCo…tySettingSelectorSubtitle");
        textView3.setText(text2);
        TextView textView4 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.serverSettingsCo…tySettingSelectorSubtitle");
        textView4.setVisibility(z2 ? 0 : 8);
        ImageView imageView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.serverSettingsCo…ttingSelectorDropdownIcon");
        imageView.setVisibility(z2 ? 0 : 8);
    }

    public final void setSubtitle(CharSequence subtitle) {
        Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsCo…tySettingSelectorSubtitle");
        textView.setText(subtitle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunitySelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_server_settings_community_setting_selector, this);
        int i2 = R.id.server_settings_community_setting_selector_description;
        TextView textView = (TextView) findViewById(R.id.server_settings_community_setting_selector_description);
        if (textView != null) {
            i2 = R.id.server_settings_community_setting_selector_dropdown_icon;
            ImageView imageView = (ImageView) findViewById(R.id.server_settings_community_setting_selector_dropdown_icon);
            if (imageView != null) {
                i2 = R.id.server_settings_community_setting_selector_subtitle;
                TextView textView2 = (TextView) findViewById(R.id.server_settings_community_setting_selector_subtitle);
                if (textView2 != null) {
                    i2 = R.id.server_settings_community_setting_selector_title;
                    TextView textView3 = (TextView) findViewById(R.id.server_settings_community_setting_selector_title);
                    if (textView3 != null) {
                        ViewServerSettingsCommunitySettingSelectorBinding viewServerSettingsCommunitySettingSelectorBinding = new ViewServerSettingsCommunitySettingSelectorBinding(this, textView, imageView, textView2, textView3);
                        Intrinsics3.checkNotNullExpressionValue(viewServerSettingsCommunitySettingSelectorBinding, "ViewServerSettingsCommun…ater.from(context), this)");
                        this.binding = viewServerSettingsCommunitySettingSelectorBinding;
                        if (attributeSet != null) {
                            initAttrs(attributeSet);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
