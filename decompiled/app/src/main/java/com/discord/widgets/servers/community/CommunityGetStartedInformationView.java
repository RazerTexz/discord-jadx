package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.ViewCommunityGetStartedInformationBinding;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CommunityGetStartedInformationView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/community/CommunityGetStartedInformationView;", "Landroidx/cardview/widget/CardView;", "Landroid/util/AttributeSet;", "attrs", "", "initAttrs", "(Landroid/util/AttributeSet;)V", "Lcom/discord/databinding/ViewCommunityGetStartedInformationBinding;", "binding", "Lcom/discord/databinding/ViewCommunityGetStartedInformationBinding;", "Landroid/content/Context;", "context", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CommunityGetStartedInformationView extends CardView {
    private final ViewCommunityGetStartedInformationBinding binding;

    /* compiled from: CommunityGetStartedInformationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.CommunityGetStartedInformationView$initAttrs$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(CommunityGetStartedInformationView.this.getContext(), R.attr.colorHeaderPrimary));
        }
    }

    public CommunityGetStartedInformationView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CommunityGetStartedInformationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ CommunityGetStartedInformationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initAttrs(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.a.CommunityGetStartedInformationView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tedInformationView, 0, 0)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(2);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(0);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.c.setImageDrawable(AppCompatResources.getDrawable(getContext(), resourceId));
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.communityListAdapterItemTextName");
        textView.setText(text);
        TextView textView2 = this.binding.f2182b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.communityListAdapterItemDescription");
        Intrinsics3.checkNotNullExpressionValue(text2, "descriptionText");
        textView2.setText(FormatUtils.g(text2, new Object[0], new AnonymousClass1()));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunityGetStartedInformationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_community_get_started_information, this);
        int i2 = R.id.community_guideline;
        Guideline guideline = (Guideline) findViewById(R.id.community_guideline);
        if (guideline != null) {
            i2 = R.id.community_list_adapter_item_description;
            TextView textView = (TextView) findViewById(R.id.community_list_adapter_item_description);
            if (textView != null) {
                i2 = R.id.community_list_adapter_item_icon;
                ImageView imageView = (ImageView) findViewById(R.id.community_list_adapter_item_icon);
                if (imageView != null) {
                    i2 = R.id.community_list_adapter_item_text_header;
                    ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.community_list_adapter_item_text_header);
                    if (constraintLayout != null) {
                        i2 = R.id.community_list_adapter_item_text_icon;
                        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.community_list_adapter_item_text_icon);
                        if (relativeLayout != null) {
                            i2 = R.id.community_list_adapter_item_text_name;
                            TextView textView2 = (TextView) findViewById(R.id.community_list_adapter_item_text_name);
                            if (textView2 != null) {
                                ViewCommunityGetStartedInformationBinding viewCommunityGetStartedInformationBinding = new ViewCommunityGetStartedInformationBinding(this, guideline, textView, imageView, constraintLayout, relativeLayout, textView2);
                                Intrinsics3.checkNotNullExpressionValue(viewCommunityGetStartedInformationBinding, "ViewCommunityGetStartedI…ater.from(context), this)");
                                this.binding = viewCommunityGetStartedInformationBinding;
                                if (attributeSet != null) {
                                    initAttrs(attributeSet);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
