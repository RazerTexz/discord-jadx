package com.discord.views.permissions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import b.a.i.ChannelPermissionOwnerViewBinding;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.models.user.User;
import com.discord.utilities.channel.ChannelPermissionUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.permissions.PermissionOwner;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ChannelPermissionOwnerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/discord/views/permissions/ChannelPermissionOwnerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "permissionOwner", "", "a", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", "Lb/a/i/g;", "j", "Lb/a/i/g;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelPermissionOwnerView extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ChannelPermissionOwnerViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelPermissionOwnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        LayoutInflater.from(context).inflate(R.layout.channel_permission_owner_view, this);
        int i = R.id.crown;
        ImageView imageView = (ImageView) findViewById(R.id.crown);
        if (imageView != null) {
            i = R.id.description;
            TextView textView = (TextView) findViewById(R.id.description);
            if (textView != null) {
                i = R.id.image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.image);
                if (simpleDraweeView != null) {
                    i = R.id.name;
                    TextView textView2 = (TextView) findViewById(R.id.name);
                    if (textView2 != null) {
                        ChannelPermissionOwnerViewBinding channelPermissionOwnerViewBinding = new ChannelPermissionOwnerViewBinding(this, imageView, textView, simpleDraweeView, textView2);
                        Intrinsics3.checkNotNullExpressionValue(channelPermissionOwnerViewBinding, "ChannelPermissionOwnerVi…ater.from(context), this)");
                        this.binding = channelPermissionOwnerViewBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(PermissionOwner permissionOwner) {
        Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
        if (!(permissionOwner instanceof PermissionOwner.Role)) {
            if (permissionOwner instanceof PermissionOwner.Member) {
                PermissionOwner.Member member = (PermissionOwner.Member) permissionOwner;
                User user = member.getUser();
                SimpleDraweeView simpleDraweeView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.image");
                IconUtils.setIcon$default(simpleDraweeView, member.getUser(), R.dimen.avatar_size_large, null, null, null, 56, null);
                TextView textView = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.name");
                String nickname = member.getNickname();
                if (nickname == null) {
                    nickname = user.getUsername();
                }
                textView.setText(nickname);
                TextView textView2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.description");
                textView2.setText(UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null));
                ImageView imageView = this.binding.f116b;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.crown");
                imageView.setVisibility(member.isOwner() ? 0 : 8);
                return;
            }
            return;
        }
        GuildRole role = ((PermissionOwner.Role) permissionOwner).getRole();
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_person_shield_24dp);
        Intrinsics3.checkNotNull(drawable);
        Intrinsics3.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl….ic_person_shield_24dp)!!");
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        DrawableCompat.setTint(drawable, RoleUtils.getRoleColor$default(role, context, null, 2, null));
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.image");
        MGImages.setImage$default(mGImages, simpleDraweeView2, drawable, (MGImages.ChangeDetector) null, 4, (Object) null);
        SimpleDraweeView simpleDraweeView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.image");
        IconUtils.setIcon$default(simpleDraweeView3, (String) null, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.name");
        textView3.setText(role.getName());
        TextView textView4 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.description");
        textView4.setText(getContext().getText(ChannelPermissionUtils.getChannelPermissionOwnerRoleLabel(role)));
        ImageView imageView2 = this.binding.f116b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.crown");
        imageView2.setVisibility(8);
    }
}
