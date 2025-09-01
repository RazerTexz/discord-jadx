package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsRolesBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.DragAndDropAdapter;
import com.discord.utilities.mg_recycler.DragAndDropHelper;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.LazyJVM;
import d0.t.CollectionsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsRoles.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b.\u0010\u0018J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\u00042\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\u00020\"8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010\u0010\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsRoles;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;", "data", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;)V", "", "", "", "newPositions", "dataSnapshot", "processRoleDrop", "(Ljava/util/Map;Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "createRole", "(JLcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter;", "adapter", "Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter;", "Lcom/discord/databinding/WidgetServerSettingsRolesBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsRolesBinding;", "binding", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "guildId$delegate", "Lkotlin/Lazy;", "getGuildId", "()J", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoles extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsRoles.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsRolesBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private WidgetServerSettingsRolesAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private ItemTouchHelper itemTouchHelper;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Companion;", "", "Landroid/content/Context;", "context", "", "guildId", "", "create", "(Landroid/content/Context;J)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("ROLES", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsRoles.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*B;\u0012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b(\u0010)J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JN\u0010\u0016\u001a\u00020\u00002\f\b\u0002\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\bR\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\u000bR\u001d\u0010\u0011\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\u0005R\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b'\u0010\u000b¨\u0006+"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "component4", "", "Lcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;", "component5", "()Ljava/util/List;", "guildId", "guildName", "canManageRoles", "elevated", "roleItems", "copy", "(JLjava/lang/String;ZZLjava/util/List;)Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getRoleItems", "Ljava/lang/String;", "getGuildName", "Z", "getCanManageRoles", "J", "getGuildId", "getElevated", "<init>", "(JLjava/lang/String;ZZLjava/util/List;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageRoles;
        private final boolean elevated;
        private final long guildId;
        private final String guildName;
        private final List<DragAndDropAdapter.Payload> roleItems;

        /* compiled from: WidgetServerSettingsRoles.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model$Companion;", "", "", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                Observable<Model> observableR = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).Y(new WidgetServerSettingsRoles2(guildId)).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(long j, String str, boolean z2, boolean z3, List<? extends DragAndDropAdapter.Payload> list) {
            Intrinsics3.checkNotNullParameter(list, "roleItems");
            this.guildId = j;
            this.guildName = str;
            this.canManageRoles = z2;
            this.elevated = z3;
            this.roleItems = list;
        }

        public static /* synthetic */ Model copy$default(Model model, long j, String str, boolean z2, boolean z3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = model.guildId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = model.guildName;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                z2 = model.canManageRoles;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                z3 = model.elevated;
            }
            boolean z5 = z3;
            if ((i & 16) != 0) {
                list = model.roleItems;
            }
            return model.copy(j2, str2, z4, z5, list);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanManageRoles() {
            return this.canManageRoles;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getElevated() {
            return this.elevated;
        }

        public final List<DragAndDropAdapter.Payload> component5() {
            return this.roleItems;
        }

        public final Model copy(long guildId, String guildName, boolean canManageRoles, boolean elevated, List<? extends DragAndDropAdapter.Payload> roleItems) {
            Intrinsics3.checkNotNullParameter(roleItems, "roleItems");
            return new Model(guildId, guildName, canManageRoles, elevated, roleItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.guildId == model.guildId && Intrinsics3.areEqual(this.guildName, model.guildName) && this.canManageRoles == model.canManageRoles && this.elevated == model.elevated && Intrinsics3.areEqual(this.roleItems, model.roleItems);
        }

        public final boolean getCanManageRoles() {
            return this.canManageRoles;
        }

        public final boolean getElevated() {
            return this.elevated;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        public final List<DragAndDropAdapter.Payload> getRoleItems() {
            return this.roleItems;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            String str = this.guildName;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.canManageRoles;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.elevated;
            int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            List<DragAndDropAdapter.Payload> list = this.roleItems;
            return i3 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guildId=");
            sbU.append(this.guildId);
            sbU.append(", guildName=");
            sbU.append(this.guildName);
            sbU.append(", canManageRoles=");
            sbU.append(this.canManageRoles);
            sbU.append(", elevated=");
            sbU.append(this.elevated);
            sbU.append(", roleItems=");
            return outline.L(sbU, this.roleItems, ")");
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/role/GuildRole;", "<name for destructuring parameter 0>", "", "invoke", "(Lcom/discord/api/role/GuildRole;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRole, Unit> {
        public final /* synthetic */ Model $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) {
            invoke2(guildRole);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRole guildRole) {
            Intrinsics3.checkNotNullParameter(guildRole, "<name for destructuring parameter 0>");
            WidgetServerSettingsEditRole.INSTANCE.launch(this.$data.getGuildId(), guildRole.getId(), WidgetServerSettingsRoles.this.requireContext());
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "", "newPositions", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Map<String, ? extends Integer>, Unit> {
        public final /* synthetic */ Model $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Model model) {
            super(1);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Integer> map) {
            invoke2((Map<String, Integer>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<String, Integer> map) {
            Intrinsics3.checkNotNullParameter(map, "newPositions");
            WidgetServerSettingsRoles.access$processRoleDrop(WidgetServerSettingsRoles.this, map, this.$data);
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass3(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsRoles.access$createRole(WidgetServerSettingsRoles.this, this.$data.getGuildId(), this.$data);
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0000 \u0001*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/role/GuildRole;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/role/GuildRole;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$createRole$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<GuildRole, Observable<? extends GuildRole>> {
        public final /* synthetic */ long $guildId;

        /* compiled from: WidgetServerSettingsRoles.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u0004\u0018\u00010\u00032.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "kotlin.jvm.PlatformType", "rolesMap", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/api/role/GuildRole;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$createRole$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03151<T, R> implements Func1<Map<Long, ? extends GuildRole>, GuildRole> {
            public final /* synthetic */ long $id;

            public C03151(long j) {
                this.$id = j;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ GuildRole call(Map<Long, ? extends GuildRole> map) {
                return call2((Map<Long, GuildRole>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final GuildRole call2(Map<Long, GuildRole> map) {
                return map.get(Long.valueOf(this.$id));
            }
        }

        public AnonymousClass1(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends GuildRole> call(GuildRole guildRole) {
            return call2(guildRole);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends GuildRole> call2(GuildRole guildRole) {
            long id2 = guildRole.getId();
            return StoreStream.INSTANCE.getGuilds().observeRoles(this.$guildId, CollectionsJVM.listOf(Long.valueOf(id2))).G(new C03151(id2));
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/role/GuildRole;", "createdRole", "", "invoke", "(Lcom/discord/api/role/GuildRole;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$createRole$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRole, Unit> {
        public final /* synthetic */ Model $dataSnapshot;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, Model model) {
            super(1);
            this.$guildId = j;
            this.$dataSnapshot = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) throws Exception {
            invoke2(guildRole);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRole guildRole) throws Exception {
            if (guildRole != null) {
                WidgetServerSettingsEditRole.INSTANCE.launch(this.$guildId, guildRole.getId(), WidgetServerSettingsRoles.this.requireContext());
            } else {
                WidgetServerSettingsRoles.access$configureUI(WidgetServerSettingsRoles.this, this.$dataSnapshot);
            }
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsRoles widgetServerSettingsRoles) {
            super(1, widgetServerSettingsRoles, WidgetServerSettingsRoles.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsRoles.access$configureUI((WidgetServerSettingsRoles) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$processRoleDrop$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.i(WidgetServerSettingsRoles.this, R.string.role_order_updated, 0, 4);
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$processRoleDrop$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Model $dataSnapshot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Model model) {
            super(1);
            this.$dataSnapshot = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetServerSettingsRoles.access$configureUI(WidgetServerSettingsRoles.this, this.$dataSnapshot);
        }
    }

    public WidgetServerSettingsRoles() {
        super(R.layout.widget_server_settings_roles);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsRoles3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsRoles4(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsRoles5.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsRoles widgetServerSettingsRoles, Model model) throws Exception {
        widgetServerSettingsRoles.configureUI(model);
    }

    public static final /* synthetic */ void access$createRole(WidgetServerSettingsRoles widgetServerSettingsRoles, long j, Model model) {
        widgetServerSettingsRoles.createRole(j, model);
    }

    public static final /* synthetic */ void access$processRoleDrop(WidgetServerSettingsRoles widgetServerSettingsRoles, Map map, Model model) {
        widgetServerSettingsRoles.processRoleDrop(map, model);
    }

    private final void configureUI(Model data) throws Exception {
        if ((data != null ? data.getRoleItems() : null) == null || data.getRoleItems().isEmpty()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        setActionBarTitle(R.string.roles);
        setActionBarSubtitle(data.getGuildName());
        WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter = this.adapter;
        if (widgetServerSettingsRolesAdapter != null) {
            widgetServerSettingsRolesAdapter.configure(data.getRoleItems(), new AnonymousClass1(data), new AnonymousClass2(data));
        }
        if (data.getCanManageRoles() && data.getElevated()) {
            getBinding().c.setOnClickListener(new AnonymousClass3(data));
            getBinding().c.show();
        } else {
            getBinding().c.hide();
            getBinding().c.setOnClickListener(null);
        }
    }

    private final void createRole(long guildId, Model dataSnapshot) {
        Observable observableY = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createRole(guildId), false, 1, null).Y(new AnonymousClass1(guildId));
        Intrinsics3.checkNotNullExpressionValue(observableY, "RestAPI\n        .api\n   … rolesMap[id] }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null), this, null, 2, null), WidgetServerSettingsRoles.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(guildId, dataSnapshot), 60, (Object) null);
    }

    private final WidgetServerSettingsRolesBinding getBinding() {
        return (WidgetServerSettingsRolesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final void processRoleDrop(Map<String, Integer> newPositions, Model dataSnapshot) {
        Set<String> setKeySet = newPositions.keySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setKeySet.iterator();
        while (true) {
            RestAPIParams.Role roleCreateForPosition = null;
            if (!it.hasNext()) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().batchUpdateRole(dataSnapshot.getGuildId(), arrayList), false, 1, null), this, null, 2, null), getBinding().f2585b, 0L, 2, null), WidgetServerSettingsRoles.class, getContext(), (Function1) null, new AnonymousClass2(dataSnapshot), (Function0) null, (Function0) null, new AnonymousClass1(), 52, (Object) null);
                return;
            }
            String str = (String) it.next();
            Integer num = newPositions.get(str);
            if (num != null) {
                roleCreateForPosition = RestAPIParams.Role.INSTANCE.createForPosition(Long.parseLong(str), num.intValue());
            }
            if (roleCreateForPosition != null) {
                arrayList.add(roleCreateForPosition);
            }
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsRolesRecycler");
        this.adapter = (WidgetServerSettingsRolesAdapter) companion.configure(new WidgetServerSettingsRolesAdapter(recyclerView));
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper != null && itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView(null);
        }
        WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter = this.adapter;
        Intrinsics3.checkNotNull(widgetServerSettingsRolesAdapter);
        ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(new DragAndDropHelper(widgetServerSettingsRolesAdapter, 0, 2, null));
        this.itemTouchHelper = itemTouchHelper2;
        if (itemTouchHelper2 != null) {
            itemTouchHelper2.attachToRecyclerView(getBinding().d);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Model.INSTANCE.get(getGuildId())), this, null, 2, null), WidgetServerSettingsRoles.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
