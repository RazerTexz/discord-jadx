package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import b.k.a.a.ColorPickerDialogListener;
import com.discord.R;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEditRoleBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.colors.ColorPickerUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetServerSettingsEditRole.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b.\u0010 J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0006J'\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditRole;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;", "data", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;)V", "setupRoleName", "setupColorSetting", "setRoleIcon", "setupHoistAndMentionSettings", "setupPermissionsSettings", "launchColorPicker", "", "everyoneLocked", "", "getLockMessage", "(Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;Z)Ljava/lang/String;", "setupMenu", "setupActionBar", "Lcom/discord/views/CheckedSetting;", "setting", "", "permission", "enableSetting", "(Lcom/discord/views/CheckedSetting;Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;J)V", "guildId", "Lcom/discord/restapi/RestAPIParams$Role;", "roleParams", "patchRole", "(JLcom/discord/restapi/RestAPIParams$Role;)V", "onViewBoundOrOnResume", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetEditRoleBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetEditRoleBinding;", "binding", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEditRole.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEditRoleBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_ROLE_ID = "INTENT_EXTRA_ROLE_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Companion;", "", "", "guildId", "roleId", "Landroid/content/Context;", "context", "", "launch", "(JJLandroid/content/Context;)V", "", WidgetServerSettingsEditRole.DIALOG_TAG_COLOR_PICKER, "Ljava/lang/String;", "INTENT_EXTRA_GUILD_ID", WidgetServerSettingsEditRole.INTENT_EXTRA_ROLE_ID, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long guildId, long roleId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetServerSettingsEditRole.INTENT_EXTRA_ROLE_ID, roleId);
            AppScreen2.d(context, WidgetServerSettingsEditRole.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0082\b\u0018\u0000 =2\u00020\u0001:\u0002=>BY\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u001e\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b;\u0010<J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004Jt\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u001e\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010,\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R!\u0010\u001e\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b1\u0010\u000fR\u0019\u0010\u001f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b3\u0010\fR\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u00104\u001a\u0004\b5\u0010\u0004R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00104\u001a\u0004\b6\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b7\u0010\fR\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\b8\u0010\u0004R\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b \u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010\u0012¨\u0006?"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;", "", "", "isEveryoneRole", "()Z", "canManage", "", "permission", "isSingular", "(J)Z", "component1", "component2", "()J", "Lcom/discord/api/role/GuildRole;", "component3", "()Lcom/discord/api/role/GuildRole;", "Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model$ManageStatus;", "component4", "()Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model$ManageStatus;", "Lcom/discord/api/permission/PermissionBit;", "component5", "()Ljava/lang/Long;", "component6", "component7", "component8", "component9", "owner", "guildId", "role", "manageStatus", "myPermissions", "myPermissionsFromOtherRoles", "isCommunityServer", "useNewThreadPermissions", "hasGuildCommunicationDisabledFeature", "copy", "(ZJLcom/discord/api/role/GuildRole;Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model$ManageStatus;Ljava/lang/Long;JZZZ)Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getMyPermissions", "Lcom/discord/api/role/GuildRole;", "getRole", "J", "getMyPermissionsFromOtherRoles", "Z", "getUseNewThreadPermissions", "getHasGuildCommunicationDisabledFeature", "getGuildId", "getOwner", "Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model$ManageStatus;", "getManageStatus", "<init>", "(ZJLcom/discord/api/role/GuildRole;Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model$ManageStatus;Ljava/lang/Long;JZZZ)V", "Companion", "ManageStatus", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long guildId;
        private final boolean hasGuildCommunicationDisabledFeature;
        private final boolean isCommunityServer;
        private final ManageStatus manageStatus;
        private final Long myPermissions;
        private final long myPermissionsFromOtherRoles;
        private final boolean owner;
        private final GuildRole role;
        private final boolean useNewThreadPermissions;

        /* compiled from: WidgetServerSettingsEditRole.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJA\u0010\n\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJC\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model$Companion;", "", "", "", "myRoleIds", "", "Lcom/discord/api/role/GuildRole;", "guildRoles", "ignoreRoleId", "guildId", "computeMyOtherPermissions", "(Ljava/util/Collection;Ljava/util/Map;JJ)J", "", "isOwner", "isElevated", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "myHighestRole", "role", "Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model$ManageStatus;", "computeManageStatus", "(ZZLjava/lang/Long;Lcom/discord/api/role/GuildRole;Lcom/discord/api/role/GuildRole;)Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model$ManageStatus;", "roleId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;", "get", "(JJ)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ ManageStatus access$computeManageStatus(Companion companion, boolean z2, boolean z3, Long l, GuildRole guildRole, GuildRole guildRole2) {
                return companion.computeManageStatus(z2, z3, l, guildRole, guildRole2);
            }

            public static final /* synthetic */ long access$computeMyOtherPermissions(Companion companion, Collection collection, Map map, long j, long j2) {
                return companion.computeMyOtherPermissions(collection, map, j, j2);
            }

            private final ManageStatus computeManageStatus(boolean isOwner, boolean isElevated, Long myPermissions, GuildRole myHighestRole, GuildRole role) {
                return (isOwner || (PermissionUtils.can(8L, myPermissions) && RoleUtils.rankIsHigher(myHighestRole, role) && isElevated)) ? ManageStatus.CAN_MANAGE_ADMIN : RoleUtils.rankIsHigher(role, myHighestRole) ? ManageStatus.LOCKED_HIGHER : RoleUtils.rankEquals(myHighestRole, role) ? ManageStatus.LOCKED_HIGHEST : (PermissionUtils.can(Permission.MANAGE_ROLES, myPermissions) && isElevated) ? ManageStatus.CAN_MANAGE_CONDITIONAL : !isElevated ? ManageStatus.USER_NOT_ELEVATED : ManageStatus.NO_MANAGE_ROLES_PERMISSION;
            }

            private final long computeMyOtherPermissions(Collection<Long> myRoleIds, Map<Long, GuildRole> guildRoles, long ignoreRoleId, long guildId) {
                GuildRole guildRole = guildRoles.get(Long.valueOf(guildId));
                long permissions = 0;
                if (guildRole != null && ignoreRoleId != guildId) {
                    permissions = guildRole.getPermissions() | 0 | guildRole.getPermissions();
                }
                Iterator<T> it = myRoleIds.iterator();
                while (it.hasNext()) {
                    long jLongValue = ((Number) it.next()).longValue();
                    GuildRole guildRole2 = guildRoles.get(Long.valueOf(jLongValue));
                    if (guildRole2 != null && jLongValue != ignoreRoleId) {
                        permissions = guildRole2.getPermissions() | permissions;
                    }
                }
                return permissions;
            }

            public final Observable<Model> get(long guildId, long roleId) {
                Observable<Model> observableR = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).Y(new WidgetServerSettingsEditRole2(guildId, roleId)).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "getUsers()\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetServerSettingsEditRole.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model$ManageStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NO_MANAGE_ROLES_PERMISSION", "LOCKED_HIGHER", "LOCKED_HIGHEST", "USER_NOT_ELEVATED", "CAN_MANAGE_CONDITIONAL", "CAN_MANAGE_ADMIN", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum ManageStatus {
            NO_MANAGE_ROLES_PERMISSION,
            LOCKED_HIGHER,
            LOCKED_HIGHEST,
            USER_NOT_ELEVATED,
            CAN_MANAGE_CONDITIONAL,
            CAN_MANAGE_ADMIN
        }

        public Model(boolean z2, long j, GuildRole guildRole, ManageStatus manageStatus, Long l, long j2, boolean z3, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(guildRole, "role");
            this.owner = z2;
            this.guildId = j;
            this.role = guildRole;
            this.manageStatus = manageStatus;
            this.myPermissions = l;
            this.myPermissionsFromOtherRoles = j2;
            this.isCommunityServer = z3;
            this.useNewThreadPermissions = z4;
            this.hasGuildCommunicationDisabledFeature = z5;
        }

        public static /* synthetic */ Model copy$default(Model model, boolean z2, long j, GuildRole guildRole, ManageStatus manageStatus, Long l, long j2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.owner : z2, (i & 2) != 0 ? model.guildId : j, (i & 4) != 0 ? model.role : guildRole, (i & 8) != 0 ? model.manageStatus : manageStatus, (i & 16) != 0 ? model.myPermissions : l, (i & 32) != 0 ? model.myPermissionsFromOtherRoles : j2, (i & 64) != 0 ? model.isCommunityServer : z3, (i & 128) != 0 ? model.useNewThreadPermissions : z4, (i & 256) != 0 ? model.hasGuildCommunicationDisabledFeature : z5);
        }

        public final boolean canManage() {
            ManageStatus manageStatus = this.manageStatus;
            return manageStatus == ManageStatus.CAN_MANAGE_CONDITIONAL || manageStatus == ManageStatus.CAN_MANAGE_ADMIN;
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getOwner() {
            return this.owner;
        }

        /* renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        /* renamed from: component4, reason: from getter */
        public final ManageStatus getManageStatus() {
            return this.manageStatus;
        }

        /* renamed from: component5, reason: from getter */
        public final Long getMyPermissions() {
            return this.myPermissions;
        }

        /* renamed from: component6, reason: from getter */
        public final long getMyPermissionsFromOtherRoles() {
            return this.myPermissionsFromOtherRoles;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsCommunityServer() {
            return this.isCommunityServer;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getUseNewThreadPermissions() {
            return this.useNewThreadPermissions;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getHasGuildCommunicationDisabledFeature() {
            return this.hasGuildCommunicationDisabledFeature;
        }

        public final Model copy(boolean owner, long guildId, GuildRole role, ManageStatus manageStatus, Long myPermissions, long myPermissionsFromOtherRoles, boolean isCommunityServer, boolean useNewThreadPermissions, boolean hasGuildCommunicationDisabledFeature) {
            Intrinsics3.checkNotNullParameter(role, "role");
            return new Model(owner, guildId, role, manageStatus, myPermissions, myPermissionsFromOtherRoles, isCommunityServer, useNewThreadPermissions, hasGuildCommunicationDisabledFeature);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.owner == model.owner && this.guildId == model.guildId && Intrinsics3.areEqual(this.role, model.role) && Intrinsics3.areEqual(this.manageStatus, model.manageStatus) && Intrinsics3.areEqual(this.myPermissions, model.myPermissions) && this.myPermissionsFromOtherRoles == model.myPermissionsFromOtherRoles && this.isCommunityServer == model.isCommunityServer && this.useNewThreadPermissions == model.useNewThreadPermissions && this.hasGuildCommunicationDisabledFeature == model.hasGuildCommunicationDisabledFeature;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final boolean getHasGuildCommunicationDisabledFeature() {
            return this.hasGuildCommunicationDisabledFeature;
        }

        public final ManageStatus getManageStatus() {
            return this.manageStatus;
        }

        public final Long getMyPermissions() {
            return this.myPermissions;
        }

        public final long getMyPermissionsFromOtherRoles() {
            return this.myPermissionsFromOtherRoles;
        }

        public final boolean getOwner() {
            return this.owner;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        public final boolean getUseNewThreadPermissions() {
            return this.useNewThreadPermissions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v21 */
        /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.owner;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int iA = (b.a(this.guildId) + (r0 * 31)) * 31;
            GuildRole guildRole = this.role;
            int iHashCode = (iA + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
            ManageStatus manageStatus = this.manageStatus;
            int iHashCode2 = (iHashCode + (manageStatus != null ? manageStatus.hashCode() : 0)) * 31;
            Long l = this.myPermissions;
            int iA2 = (b.a(this.myPermissionsFromOtherRoles) + ((iHashCode2 + (l != null ? l.hashCode() : 0)) * 31)) * 31;
            ?? r2 = this.isCommunityServer;
            int i = r2;
            if (r2 != 0) {
                i = 1;
            }
            int i2 = (iA2 + i) * 31;
            ?? r22 = this.useNewThreadPermissions;
            int i3 = r22;
            if (r22 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z3 = this.hasGuildCommunicationDisabledFeature;
            return i4 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isCommunityServer() {
            return this.isCommunityServer;
        }

        public final boolean isEveryoneRole() {
            return this.role.getId() == this.guildId;
        }

        public final boolean isSingular(long permission) {
            return (this.owner || (this.myPermissionsFromOtherRoles & permission) == permission) ? false : true;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(owner=");
            sbU.append(this.owner);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", role=");
            sbU.append(this.role);
            sbU.append(", manageStatus=");
            sbU.append(this.manageStatus);
            sbU.append(", myPermissions=");
            sbU.append(this.myPermissions);
            sbU.append(", myPermissionsFromOtherRoles=");
            sbU.append(this.myPermissionsFromOtherRoles);
            sbU.append(", isCommunityServer=");
            sbU.append(this.isCommunityServer);
            sbU.append(", useNewThreadPermissions=");
            sbU.append(this.useNewThreadPermissions);
            sbU.append(", hasGuildCommunicationDisabledFeature=");
            return outline.O(sbU, this.hasGuildCommunicationDisabledFeature, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            Model.ManageStatus.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[Model.ManageStatus.CAN_MANAGE_CONDITIONAL.ordinal()] = 1;
            iArr[Model.ManageStatus.CAN_MANAGE_ADMIN.ordinal()] = 2;
            Model.ManageStatus.values();
            int[] iArr2 = new int[6];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Model.ManageStatus.NO_MANAGE_ROLES_PERMISSION.ordinal()] = 1;
            iArr2[Model.ManageStatus.LOCKED_HIGHER.ordinal()] = 2;
            iArr2[Model.ManageStatus.LOCKED_HIGHEST.ordinal()] = 3;
            iArr2[Model.ManageStatus.USER_NOT_ELEVATED.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass1(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextInputLayout textInputLayout = WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f2371b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editRoleName");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            int length = textOrEmpty.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = Intrinsics3.compare(textOrEmpty.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            String string = textOrEmpty.subSequence(i, length + 1).toString();
            if (!(string.length() > 0)) {
                AppToast.i(WidgetServerSettingsEditRole.this, R.string.form_label_role_enter_name, 0, 4);
                return;
            }
            TextInputLayout textInputLayout2 = WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f2371b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editRoleName");
            textInputLayout2.setSelected(false);
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            roleCreateWithRole.setName(string);
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
            AppFragment.hideKeyboard$default(WidgetServerSettingsEditRole.this, null, 1, null);
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$enableSetting$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $data;
        public final /* synthetic */ long $permission;

        public AnonymousClass1(Model model, long j) {
            this.$data = model;
            this.$permission = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f2371b.clearFocus();
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            roleCreateWithRole.setPermissions(Long.valueOf(this.$data.getRole().getPermissions() ^ this.$permission));
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"com/discord/widgets/servers/WidgetServerSettingsEditRole$launchColorPicker$1", "Lb/k/a/a/f;", "", "dialogId", "selectedColor", "", "onColorSelected", "(II)V", "onColorReset", "(I)V", "onDialogDismissed", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$launchColorPicker$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ColorPickerDialogListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass1(Model model) {
            this.$data = model;
        }

        @Override // b.k.a.a.ColorPickerDialogListener
        public void onColorReset(int dialogId) {
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            roleCreateWithRole.setColor(0);
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
        }

        @Override // b.k.a.a.ColorPickerDialogListener
        public void onColorSelected(int dialogId, int selectedColor) {
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            roleCreateWithRole.setColor(Integer.valueOf(ColorCompat.INSTANCE.removeAlphaComponent(selectedColor)));
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
        }

        @Override // b.k.a.a.ColorPickerDialogListener
        public void onDialogDismissed(int dialogId) {
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsEditRole widgetServerSettingsEditRole) {
            super(1, widgetServerSettingsEditRole, WidgetServerSettingsEditRole.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsEditRole.access$configureUI((WidgetServerSettingsEditRole) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$patchRole$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r1) {
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "colorInt", "Landroid/text/SpannableStringBuilder;", "invoke", "(Ljava/lang/String;I)Landroid/text/SpannableStringBuilder;", "getColoredSpan"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupActionBar$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<String, Integer, SpannableStringBuilder> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ SpannableStringBuilder invoke(String str, Integer num) {
            return invoke(str, num.intValue());
        }

        public final SpannableStringBuilder invoke(String str, @ColorInt int i) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, spannableStringBuilder.length(), 0);
            return spannableStringBuilder;
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupColorSetting$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass1(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.access$launchColorPicker(WidgetServerSettingsEditRole.this, this.$data);
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupColorSetting$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass2(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole widgetServerSettingsEditRole = WidgetServerSettingsEditRole.this;
            AppToast.j(widgetServerSettingsEditRole, WidgetServerSettingsEditRole.access$getLockMessage(widgetServerSettingsEditRole, this.$data, true), 0, 4);
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupHoistAndMentionSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass1(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f2371b.clearFocus();
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).q, "binding.roleSettingsHoistCheckedsetting");
            roleCreateWithRole.setHoist(Boolean.valueOf(!r0.isChecked()));
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupHoistAndMentionSettings$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass2(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f2371b.clearFocus();
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).D, "binding.roleSettingsMentionableCheckedsetting");
            roleCreateWithRole.setMentionable(Boolean.valueOf(!r0.isChecked()));
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "menuItem", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupMenu$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Model $data;

        /* compiled from: WidgetServerSettingsEditRole.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupMenu$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03091<T> implements Action1<Void> {
            public C03091() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Void r1) throws Exception {
                call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Void r1) throws Exception {
                AppActivity appActivity = WidgetServerSettingsEditRole.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.onBackPressed();
                }
            }
        }

        public AnonymousClass1(Model model) {
            this.$data = model;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullParameter(menuItem, "menuItem");
            if (menuItem.getItemId() == R.id.menu_edit_role_delete) {
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteRole(this.$data.getGuildId(), this.$data.getRole().getId()), false, 1, null), WidgetServerSettingsEditRole.this, null, 2, null).k(o.j(new C03091(), WidgetServerSettingsEditRole.this.getContext(), null, 4));
            }
        }
    }

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupRoleName$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass1(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole widgetServerSettingsEditRole = WidgetServerSettingsEditRole.this;
            AppToast.j(widgetServerSettingsEditRole, WidgetServerSettingsEditRole.access$getLockMessage(widgetServerSettingsEditRole, this.$data, true), 0, 4);
        }
    }

    public WidgetServerSettingsEditRole() {
        super(R.layout.widget_edit_role);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEditRole3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.edit_role_name);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEditRole widgetServerSettingsEditRole, Model model) {
        widgetServerSettingsEditRole.configureUI(model);
    }

    public static final /* synthetic */ WidgetEditRoleBinding access$getBinding$p(WidgetServerSettingsEditRole widgetServerSettingsEditRole) {
        return widgetServerSettingsEditRole.getBinding();
    }

    public static final /* synthetic */ String access$getLockMessage(WidgetServerSettingsEditRole widgetServerSettingsEditRole, Model model, boolean z2) {
        return widgetServerSettingsEditRole.getLockMessage(model, z2);
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetServerSettingsEditRole widgetServerSettingsEditRole, Model model) {
        widgetServerSettingsEditRole.launchColorPicker(model);
    }

    public static final /* synthetic */ void access$patchRole(WidgetServerSettingsEditRole widgetServerSettingsEditRole, long j, RestAPIParams.Role role) {
        widgetServerSettingsEditRole.patchRole(j, role);
    }

    private final void configureUI(Model data) {
        if ((data != null ? data.getRole() : null) == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setupMenu(data);
        setupActionBar(data);
        setupRoleName(data);
        setupHoistAndMentionSettings(data);
        setupPermissionsSettings(data);
        setupColorSetting(data);
        setRoleIcon(data);
        this.state.configureSaveActionView(getBinding().c);
        getBinding().c.setOnClickListener(new AnonymousClass1(data));
        if (data.getUseNewThreadPermissions()) {
            return;
        }
        CheckedSetting.i(getBinding().M, getString(R.string.role_permissions_send_messages_description), false, 2);
        getBinding().N.setText(getString(R.string.interim_send_messages_in_threads));
        getBinding().N.h(FormatUtils.k(this, R.string.interim_role_permissions_send_messages_in_threads_description, new Object[0], null, 4), true);
        getBinding().m.setText(getString(R.string.interim_create_public_threads));
        getBinding().m.h(FormatUtils.k(this, R.string.interim_role_permissions_create_public_threads_description, new Object[0], null, 4), true);
        getBinding().l.setText(getString(R.string.interim_create_private_threads));
        getBinding().l.h(FormatUtils.k(this, R.string.interim_role_permissions_create_private_threads_description, new Object[0], null, 4), true);
    }

    private final void enableSetting(CheckedSetting setting, Model data, long permission) {
        setting.e(new AnonymousClass1(data, permission));
    }

    private final WidgetEditRoleBinding getBinding() {
        return (WidgetEditRoleBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getLockMessage(Model data, boolean everyoneLocked) {
        String string;
        if (everyoneLocked && data.isEveryoneRole()) {
            String string2 = getString(R.string.form_label_disabled_for_everyone);
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.form_…el_disabled_for_everyone)");
            return string2;
        }
        Model.ManageStatus manageStatus = data.getManageStatus();
        if (manageStatus != null) {
            int iOrdinal = manageStatus.ordinal();
            string = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? "" : getString(R.string.two_fa_guild_mfa_warning_ios) : getString(R.string.help_role_locked_mine) : getString(R.string.help_role_locked) : getString(R.string.help_missing_manage_roles_permission);
        }
        Intrinsics3.checkNotNullExpressionValue(string, "when (data.manageStatus)…s)\n      else -> \"\"\n    }");
        return string;
    }

    public static final void launch(long j, long j2, Context context) {
        INSTANCE.launch(j, j2, context);
    }

    private final void launchColorPicker(Model data) {
        ColorPickerDialog colorPickerDialogBuildColorPickerDialog = ColorPickerUtils.INSTANCE.buildColorPickerDialog(requireContext(), R.string.role_color, RoleUtils.getRoleColor$default(data.getRole(), requireContext(), null, 2, null));
        colorPickerDialogBuildColorPickerDialog.k = new AnonymousClass1(data);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogBuildColorPickerDialog.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final void patchRole(long guildId, RestAPIParams.Role roleParams) {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateRole(guildId, roleParams.getId(), roleParams), false, 1, null), this, null, 2, null).k(o.j(AnonymousClass1.INSTANCE, getContext(), null, 4));
    }

    private final void setRoleIcon(Model data) {
        if (data.getRole().getIcon() != null) {
            String icon = data.getRole().getIcon();
            Intrinsics3.checkNotNull(icon);
            if (icon.length() > 0) {
                getBinding().J.setRole(data.getRole(), Long.valueOf(data.getGuildId()));
                TextView textView = getBinding().L;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.roleSettingsRoleIconHeader");
                textView.setVisibility(0);
                View view = getBinding().K;
                Intrinsics3.checkNotNullExpressionValue(view, "binding.roleSettingsRoleIconDivider");
                view.setVisibility(0);
                RelativeLayout relativeLayout = getBinding().r;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.roleSettingsIconContainer");
                relativeLayout.setVisibility(0);
                return;
            }
        }
        TextView textView2 = getBinding().L;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.roleSettingsRoleIconHeader");
        textView2.setVisibility(8);
        View view2 = getBinding().K;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.roleSettingsRoleIconDivider");
        view2.setVisibility(8);
        RelativeLayout relativeLayout2 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.roleSettingsIconContainer");
        relativeLayout2.setVisibility(8);
    }

    private final void setupActionBar(Model data) {
        int iHSVToColor;
        AppActivity appActivity = getAppActivity();
        Toolbar toolbar = appActivity != null ? appActivity.toolbar : null;
        if (toolbar != null) {
            int roleColor = RoleUtils.getRoleColor(data.getRole(), requireContext(), Integer.valueOf(ColorCompat.getThemedColor(requireContext(), R.attr.color_brand)));
            if (RoleUtils.isDefaultColor(data.getRole())) {
                iHSVToColor = ColorCompat.getThemedColor(this, R.attr.color_brand_460);
            } else {
                float[] fArr = new float[3];
                Color.colorToHSV(roleColor, fArr);
                fArr[2] = fArr[2] * 0.5f;
                iHSVToColor = Color.HSVToColor(fArr);
            }
            boolean zIsColorDark$default = ColorCompat.isColorDark$default(roleColor, 0.0f, 2, null);
            int color = ColorCompat.getColor(requireContext(), zIsColorDark$default ? R.color.primary_100 : R.color.primary_500);
            ColorCompat.setStatusBarColor(this, iHSVToColor, zIsColorDark$default);
            AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            String string = getString(R.string.form_label_role_settings);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.form_label_role_settings)");
            setActionBarTitle(anonymousClass1.invoke(string, color));
            setActionBarSubtitle(anonymousClass1.invoke(data.getRole().getName(), color));
            toolbar.setBackgroundColor(roleColor);
            Drawable navigationIcon = toolbar.getNavigationIcon();
            if (navigationIcon != null) {
                navigationIcon.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
            }
            Drawable overflowIcon = toolbar.getOverflowIcon();
            if (overflowIcon != null) {
                overflowIcon.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
            }
        }
    }

    private final void setupColorSetting(Model data) {
        View view = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.roleSettingsCurrentColorDisplay");
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.drawable_circle_white_1);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(RoleUtils.getRoleColor$default(data.getRole(), requireContext(), null, 2, null), PorterDuff.Mode.SRC_ATOP));
            View view2 = getBinding().n;
            Intrinsics3.checkNotNullExpressionValue(view2, "binding.roleSettingsCurrentColorDisplay");
            view2.setBackground(drawable);
        }
        if (!data.canManage() || data.isEveryoneRole()) {
            View view3 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(view3, "binding.roleSettingsColorDisabledOverlay");
            view3.setVisibility(0);
            getBinding().i.setOnClickListener(new AnonymousClass2(data));
            return;
        }
        getBinding().j.setOnClickListener(new AnonymousClass1(data));
        View view4 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(view4, "binding.roleSettingsColorDisabledOverlay");
        view4.setVisibility(8);
        getBinding().i.setOnClickListener(null);
    }

    private final void setupHoistAndMentionSettings(Model data) {
        CheckedSetting checkedSetting = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.roleSettingsHoistCheckedsetting");
        checkedSetting.setChecked(data.getRole().getHoist());
        CheckedSetting checkedSetting2 = getBinding().D;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.roleSettingsMentionableCheckedsetting");
        checkedSetting2.setChecked(data.getRole().getMentionable());
        if (data.canManage() && !data.isEveryoneRole()) {
            getBinding().q.e(new AnonymousClass1(data));
            getBinding().D.e(new AnonymousClass2(data));
        } else {
            String lockMessage = getLockMessage(data, true);
            getBinding().q.c(lockMessage);
            getBinding().D.c(lockMessage);
        }
    }

    private final void setupMenu(Model data) {
        if (!data.canManage() || data.isEveryoneRole() || data.getRole().getManaged()) {
            AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_empty, null, null, 4, null);
        } else {
            AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_edit_role, new AnonymousClass1(data), null, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupPermissionsSettings(Model data) {
        long j;
        for (CheckedSetting checkedSetting : Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().e, getBinding().f, getBinding().g, getBinding().h, getBinding().k, getBinding().p, getBinding().f2372s, getBinding().t, getBinding().w, getBinding().A, getBinding().f2373x, getBinding().u, getBinding().f2374y, getBinding().f2375z, getBinding().E, getBinding().B, getBinding().C, getBinding().G, getBinding().H, getBinding().M, getBinding().N, getBinding().m, getBinding().l, getBinding().O, getBinding().P, getBinding().Q, getBinding().R, getBinding().d, getBinding().S, getBinding().U, getBinding().Y, getBinding().f2370a0, getBinding().X, getBinding().V, getBinding().W, getBinding().Z, getBinding().F, getBinding().T, getBinding().I, getBinding().v})) {
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "setting");
            switch (checkedSetting.getId()) {
                case R.id.role_settings_add_reactions /* 2131364965 */:
                    j = 64;
                    break;
                case R.id.role_settings_administrator /* 2131364966 */:
                    j = 8;
                    break;
                case R.id.role_settings_attach_files /* 2131364967 */:
                    j = Permission.ATTACH_FILES;
                    break;
                case R.id.role_settings_ban_members /* 2131364968 */:
                    j = 4;
                    break;
                case R.id.role_settings_change_nickname /* 2131364969 */:
                    j = Permission.CHANGE_NICKNAME;
                    break;
                case R.id.role_settings_color_disabled_overlay /* 2131364970 */:
                case R.id.role_settings_color_selector_container /* 2131364971 */:
                case R.id.role_settings_current_color_display /* 2131364975 */:
                case R.id.role_settings_edit_name_disabled_overlay /* 2131364976 */:
                case R.id.role_settings_hoist_checkedsetting /* 2131364978 */:
                case R.id.role_settings_icon_container /* 2131364979 */:
                case R.id.role_settings_mentionable_checkedsetting /* 2131364991 */:
                case R.id.role_settings_overview_scroll /* 2131364993 */:
                case R.id.role_settings_role_icon /* 2131364998 */:
                case R.id.role_settings_role_icon_divider /* 2131364999 */:
                case R.id.role_settings_role_icon_header /* 2131365000 */:
                default:
                    j = 0;
                    break;
                case R.id.role_settings_create_instant_invite /* 2131364972 */:
                    j = 1;
                    break;
                case R.id.role_settings_create_private_threads /* 2131364973 */:
                    j = Permission.CREATE_PRIVATE_THREADS;
                    break;
                case R.id.role_settings_create_public_threads /* 2131364974 */:
                    j = Permission.CREATE_PUBLIC_THREADS;
                    break;
                case R.id.role_settings_embed_links /* 2131364977 */:
                    j = Permission.EMBED_LINKS;
                    break;
                case R.id.role_settings_kick_members /* 2131364980 */:
                    j = 2;
                    break;
                case R.id.role_settings_manage_channels /* 2131364981 */:
                    j = 16;
                    break;
                case R.id.role_settings_manage_emojis_and_stickers /* 2131364982 */:
                    j = Permission.MANAGE_EMOJIS_AND_STICKERS;
                    break;
                case R.id.role_settings_manage_events /* 2131364983 */:
                    j = Permission.MANAGE_EVENTS;
                    break;
                case R.id.role_settings_manage_messages /* 2131364984 */:
                    j = Permission.MANAGE_MESSAGES;
                    break;
                case R.id.role_settings_manage_nicknames /* 2131364985 */:
                    j = Permission.MANAGE_NICKNAMES;
                    break;
                case R.id.role_settings_manage_roles /* 2131364986 */:
                    j = Permission.MANAGE_ROLES;
                    break;
                case R.id.role_settings_manage_server /* 2131364987 */:
                    j = 32;
                    break;
                case R.id.role_settings_manage_threads /* 2131364988 */:
                    j = Permission.MANAGE_THREADS;
                    break;
                case R.id.role_settings_manage_webhooks /* 2131364989 */:
                    j = Permission.MANAGE_WEBHOOKS;
                    break;
                case R.id.role_settings_mention_everyone /* 2131364990 */:
                    j = Permission.MENTION_EVERYONE;
                    break;
                case R.id.role_settings_moderate_member /* 2131364992 */:
                    j = Permission.MODERATE_MEMBERS;
                    break;
                case R.id.role_settings_priority_speaker /* 2131364994 */:
                    j = 256;
                    break;
                case R.id.role_settings_read_message_history /* 2131364995 */:
                    j = Permission.READ_MESSAGE_HISTORY;
                    break;
                case R.id.role_settings_read_messages /* 2131364996 */:
                    j = Permission.VIEW_CHANNEL;
                    break;
                case R.id.role_settings_request_to_speak /* 2131364997 */:
                    j = Permission.REQUEST_TO_SPEAK;
                    break;
                case R.id.role_settings_send_messages /* 2131365001 */:
                    j = Permission.SEND_MESSAGES;
                    break;
                case R.id.role_settings_send_messages_in_threads /* 2131365002 */:
                    j = Permission.SEND_MESSAGES_IN_THREADS;
                    break;
                case R.id.role_settings_send_tts_messages /* 2131365003 */:
                    j = Permission.SEND_TTS_MESSAGES;
                    break;
                case R.id.role_settings_use_application_commands /* 2131365004 */:
                    j = Permission.USE_APPLICATION_COMMANDS;
                    break;
                case R.id.role_settings_use_external_emojis /* 2131365005 */:
                    j = Permission.USE_EXTERNAL_EMOJIS;
                    break;
                case R.id.role_settings_use_external_stickers /* 2131365006 */:
                    j = Permission.USE_EXTERNAL_STICKERS;
                    break;
                case R.id.role_settings_view_audit_log /* 2131365007 */:
                    j = 128;
                    break;
                case R.id.role_settings_view_guild_analytics /* 2131365008 */:
                    j = Permission.VIEW_GUILD_ANALYTICS;
                    break;
                case R.id.role_settings_voice_connect /* 2131365009 */:
                    j = Permission.CONNECT;
                    break;
                case R.id.role_settings_voice_deafen_members /* 2131365010 */:
                    j = Permission.DEAFEN_MEMBERS;
                    break;
                case R.id.role_settings_voice_move_members /* 2131365011 */:
                    j = Permission.MOVE_MEMBERS;
                    break;
                case R.id.role_settings_voice_mute_members /* 2131365012 */:
                    j = Permission.MUTE_MEMBERS;
                    break;
                case R.id.role_settings_voice_speak /* 2131365013 */:
                    j = Permission.SPEAK;
                    break;
                case R.id.role_settings_voice_use_voice_activity /* 2131365014 */:
                    j = Permission.USE_VAD;
                    break;
                case R.id.role_settings_voice_video /* 2131365015 */:
                    j = 512;
                    break;
            }
            boolean zCan = PermissionUtils.can(j, Long.valueOf(data.getRole().getPermissions()));
            checkedSetting.setChecked(zCan);
            boolean zCan2 = PermissionUtils.can(j, data.getMyPermissions());
            Model.ManageStatus manageStatus = data.getManageStatus();
            if (manageStatus != null) {
                int iOrdinal = manageStatus.ordinal();
                if (iOrdinal != 4) {
                    if (iOrdinal != 5) {
                        checkedSetting.c(getLockMessage(data, false));
                    } else if (!data.getOwner() && j == 8 && data.isSingular(j)) {
                        checkedSetting.b(R.string.help_singular_permission);
                    } else {
                        enableSetting(checkedSetting, data, j);
                    }
                } else if (zCan2 && !(data.isSingular(j) && zCan)) {
                    enableSetting(checkedSetting, data, j);
                } else if (zCan2) {
                    checkedSetting.b(R.string.help_singular_permission);
                } else {
                    checkedSetting.b(R.string.help_missing_permission);
                }
            }
            checkedSetting.setVisibility(((j > Permission.VIEW_GUILD_ANALYTICS ? 1 : (j == Permission.VIEW_GUILD_ANALYTICS ? 0 : -1)) == 0 && !data.isCommunityServer()) ^ true ? 0 : 8);
        }
        CheckedSetting checkedSetting2 = getBinding().E;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.roleSettingsModerateMember");
        checkedSetting2.setVisibility(data.getHasGuildCommunicationDisabledFeature() ? 0 : 8);
    }

    private final void setupRoleName(Model data) {
        TextInputLayout textInputLayout = getBinding().f2371b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editRoleName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f2371b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editRoleName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), data.getRole().getName()));
        if (!data.canManage() || data.isEveryoneRole()) {
            View view = getBinding().o;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.roleSettingsEditNameDisabledOverlay");
            view.setVisibility(0);
            getBinding().o.setOnClickListener(new AnonymousClass1(data));
            return;
        }
        View view2 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.roleSettingsEditNameDisabledOverlay");
        view2.setVisibility(8);
        getBinding().o.setOnClickListener(null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().c;
        TextInputLayout textInputLayout = getBinding().f2371b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editRoleName");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
        FloatingActionButton floatingActionButton2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton2, "binding.editRoleSave");
        floatingActionButton2.setVisibility(8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Model.INSTANCE.get(getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L), getMostRecentIntent().getLongExtra(INTENT_EXTRA_ROLE_ID, -1L))), this, null, 2, null), WidgetServerSettingsEditRole.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Fragment fragmentFindFragmentByTag = parentFragmentManager.findFragmentByTag(DIALOG_TAG_COLOR_PICKER);
        if (fragmentFindFragmentByTag != null) {
            parentFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
    }
}
