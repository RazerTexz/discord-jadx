package com.discord.widgets.guilds.profile;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetAnnouncementGuildProfileSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetPublicAnnouncementProfileSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetAnnouncementGuildProfileSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetAnnouncementGuildProfileSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.WidgetPublicAnnouncementProfileSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetPublicAnnouncementProfileSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetAnnouncementGuildProfileSheetBinding> {
    public static final WidgetPublicAnnouncementProfileSheet2 INSTANCE = new WidgetPublicAnnouncementProfileSheet2();

    public WidgetPublicAnnouncementProfileSheet2() {
        super(1, WidgetAnnouncementGuildProfileSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAnnouncementGuildProfileSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAnnouncementGuildProfileSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAnnouncementGuildProfileSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.announcement_guild_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.announcement_guild_avatar);
        if (simpleDraweeView != null) {
            i = R.id.announcement_guild_description;
            TextView textView = (TextView) view.findViewById(R.id.announcement_guild_description);
            if (textView != null) {
                i = R.id.announcement_guild_here_to_help;
                TextView textView2 = (TextView) view.findViewById(R.id.announcement_guild_here_to_help);
                if (textView2 != null) {
                    i = R.id.announcement_guild_name;
                    TextView textView3 = (TextView) view.findViewById(R.id.announcement_guild_name);
                    if (textView3 != null) {
                        i = R.id.announcement_guild_staff_icon;
                        ImageView imageView = (ImageView) view.findViewById(R.id.announcement_guild_staff_icon);
                        if (imageView != null) {
                            return new WidgetAnnouncementGuildProfileSheetBinding((NestedScrollView) view, simpleDraweeView, textView, textView2, textView3, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
