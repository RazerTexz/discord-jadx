package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.f.g.e.r;
import b.f.g.e.v;
import b.f.g.f.RoundingParams;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.ViewGuildRoleSubscriptionImageUploadBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildSubscriptionRoleImageUploadView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00010B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,B\u001d\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b+\u0010-B'\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010.\u001a\u00020#¢\u0006\u0004\b+\u0010/J\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0006\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0017\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u000b\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u000b\u0010\u001cJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u000b\u0010\u001fR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u00061"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/GuildSubscriptionRoleImageUploadView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/util/AttributeSet;", "attrs", "", "initialize", "(Landroid/util/AttributeSet;)V", "", "Lcom/discord/primitives/ApplicationId;", "applicationId", "imageAssetId", "updateImage", "(Ljava/lang/Long;J)V", "", "imageUrl", "(Ljava/lang/String;)V", "", "hasImage", "updateImageVisibility", "(Z)V", "Lkotlin/Function0;", "onImageRemoved", "onImageChooserClicked", "configureUI", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "memberIcon", "Lcom/discord/api/role/GuildRole;", "guildRole", "(Ljava/lang/String;Lcom/discord/api/role/GuildRole;)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "guildSubscriptionTier", "(Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;)V", "onImageChooserClickListener", "Lkotlin/jvm/functions/Function0;", "onImageRemovedListener", "", "avatarSize", "I", "Lcom/discord/databinding/ViewGuildRoleSubscriptionImageUploadBinding;", "binding", "Lcom/discord/databinding/ViewGuildRoleSubscriptionImageUploadBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildSubscriptionRoleImageUploadView extends ConstraintLayout {
    private static final int CIRCLE_IMAGE_STYLE = 0;
    private static final int ROUNDED_IMAGE_STYLE = 1;
    private int avatarSize;
    private final ViewGuildRoleSubscriptionImageUploadBinding binding;
    private Function0<Unit> onImageChooserClickListener;
    private Function0<Unit> onImageRemovedListener;

    /* compiled from: GuildSubscriptionRoleImageUploadView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView$initialize$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnImageChooserClickListener$p = GuildSubscriptionRoleImageUploadView.access$getOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView.this);
            if (function0Access$getOnImageChooserClickListener$p != null) {
            }
        }
    }

    /* compiled from: GuildSubscriptionRoleImageUploadView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView$initialize$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnImageChooserClickListener$p = GuildSubscriptionRoleImageUploadView.access$getOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView.this);
            if (function0Access$getOnImageChooserClickListener$p != null) {
            }
        }
    }

    /* compiled from: GuildSubscriptionRoleImageUploadView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView$initialize$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnImageChooserClickListener$p = GuildSubscriptionRoleImageUploadView.access$getOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView.this);
            if (function0Access$getOnImageChooserClickListener$p != null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptionRoleImageUploadView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingA = ViewGuildRoleSubscriptionImageUploadBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingA;
        this.avatarSize = getResources().getDimensionPixelSize(R.dimen.avatar_size_huge);
        initialize$default(this, null, 1, null);
    }

    public static final /* synthetic */ Function0 access$getOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView) {
        return guildSubscriptionRoleImageUploadView.onImageChooserClickListener;
    }

    public static final /* synthetic */ void access$setOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView, Function0 function0) {
        guildSubscriptionRoleImageUploadView.onImageChooserClickListener = function0;
    }

    private final void initialize(AttributeSet attrs) {
        ScalingUtils$ScaleType scalingUtils$ScaleType;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int[] iArr = R.a.GuildSubscriptionRoleImageUploadView;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.GuildSubscriptionRoleImageUploadView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        if (typedArrayObtainStyledAttributes.getBoolean(4, false)) {
            ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.a;
            scalingUtils$ScaleType = r.l;
        } else {
            ScalingUtils$ScaleType scalingUtils$ScaleType3 = ScalingUtils$ScaleType.a;
            scalingUtils$ScaleType = v.l;
        }
        SimpleDraweeView simpleDraweeView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
        GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
        Intrinsics3.checkNotNullExpressionValue(hierarchy, "binding.guildSubscriptionImage.hierarchy");
        hierarchy.n(scalingUtils$ScaleType);
        int i = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (i == 0) {
            this.binding.d.setBackgroundResource(DrawableCompat.getThemedDrawableRes(this, R.attr.primary_700_circle, 0));
        } else if (i == 1) {
            SimpleDraweeView simpleDraweeView2 = this.binding.d;
            simpleDraweeView2.setBackgroundResource(R.drawable.drawable_rect_rounded_bg_tertiary);
            GenericDraweeHierarchy hierarchy2 = simpleDraweeView2.getHierarchy();
            Intrinsics3.checkNotNullExpressionValue(hierarchy2, "hierarchy");
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.f523b = false;
            hierarchy2.s(roundingParams);
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildSubscriptio…            }\n          }");
        }
        String string = typedArrayObtainStyledAttributes.getString(3);
        if (string == null) {
            string = getContext().getString(R.string.guild_role_subscription_tier_detail_custom_image_label);
        }
        Intrinsics3.checkNotNullExpressionValue(string, "it.getString(R.styleable…etail_custom_image_label)");
        TextView textView = this.binding.f2195b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildSubscriptionCustomImageTitle");
        textView.setText(string);
        String string2 = typedArrayObtainStyledAttributes.getString(0);
        if (string2 == null) {
            string2 = getContext().getString(R.string.guild_role_subscription_tier_detail_custom_image_description);
        }
        Intrinsics3.checkNotNullExpressionValue(string2, "it.getString(R.styleable…image_description\n      )");
        TextView textView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildSubscriptionUploadImageLabel");
        textView2.setText(string2);
        this.avatarSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(R.dimen.avatar_size_huge));
        typedArrayObtainStyledAttributes.recycle();
        this.binding.e.setOnClickListener(new AnonymousClass2());
        this.binding.d.setOnClickListener(new AnonymousClass3());
        this.binding.c.setOnClickListener(new AnonymousClass4());
    }

    public static /* synthetic */ void initialize$default(GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView, AttributeSet attributeSet, int i, Object obj) {
        if ((i & 1) != 0) {
            attributeSet = null;
        }
        guildSubscriptionRoleImageUploadView.initialize(attributeSet);
    }

    private final void updateImageVisibility(boolean hasImage) {
        ImageView imageView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildSubscriptionEditImage");
        imageView.setVisibility(hasImage ? 0 : 8);
        if (hasImage) {
            this.binding.e.setText(R.string.avatar_upload_edit_media);
        } else {
            this.binding.e.setText(R.string.guild_role_subscription_tier_detail_custom_image_button);
        }
    }

    public final void configureUI(Function0<Unit> onImageRemoved, Function0<Unit> onImageChooserClicked) {
        Intrinsics3.checkNotNullParameter(onImageRemoved, "onImageRemoved");
        Intrinsics3.checkNotNullParameter(onImageChooserClicked, "onImageChooserClicked");
        this.onImageRemovedListener = onImageRemoved;
        this.onImageChooserClickListener = onImageChooserClicked;
    }

    public final void updateImage(String memberIcon, GuildRole guildRole) {
        if (!(memberIcon == null || StringsJVM.isBlank(memberIcon))) {
            updateImage(memberIcon);
            return;
        }
        if (guildRole != null) {
            String icon = guildRole.getIcon();
            if (!(icon == null || StringsJVM.isBlank(icon))) {
                SimpleDraweeView simpleDraweeView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
                IconUtils.setIcon$default(simpleDraweeView, guildRole, R.dimen.avatar_size_huge, (MGImages.ChangeDetector) null, 8, (Object) null);
                updateImageVisibility(true);
                return;
            }
        }
        updateImage((String) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingA = ViewGuildRoleSubscriptionImageUploadBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingA;
        this.avatarSize = getResources().getDimensionPixelSize(R.dimen.avatar_size_huge);
        initialize(attributeSet);
    }

    public final void updateImage(GuildRoleSubscriptionTier guildSubscriptionTier) {
        Intrinsics3.checkNotNullParameter(guildSubscriptionTier, "guildSubscriptionTier");
        String image = guildSubscriptionTier.getImage();
        if ((image == null || StringsJVM.isBlank(image)) && guildSubscriptionTier.getImageAssetId() != null) {
            updateImage(guildSubscriptionTier.getApplicationId(), guildSubscriptionTier.getImageAssetId().longValue());
        } else {
            updateImage(guildSubscriptionTier.getImage());
        }
    }

    public /* synthetic */ GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingA = ViewGuildRoleSubscriptionImageUploadBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingA;
        this.avatarSize = getResources().getDimensionPixelSize(R.dimen.avatar_size_huge);
        initialize(attributeSet);
    }

    private final void updateImage(Long applicationId, long imageAssetId) {
        updateImage(IconUtils.INSTANCE.getStoreAssetImage(applicationId, String.valueOf(imageAssetId), this.avatarSize));
    }

    private final void updateImage(String imageUrl) {
        SimpleDraweeView simpleDraweeView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
        int i = this.avatarSize;
        IconUtils.setIcon$default(simpleDraweeView, imageUrl, i, i, false, null, null, 112, null);
        updateImageVisibility(!(imageUrl == null || StringsJVM.isBlank(imageUrl)));
    }

    public /* synthetic */ GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
