package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsEmojisEditBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetServerSettingsEmojisEdit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b#\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u001a\u0010\"\u001a\u00060\u0017j\u0002`!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0019¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojisEdit;", "Lcom/discord/app/AppFragment;", "", "emojiName", "", "configureToolbar", "(Ljava/lang/String;)V", "configureMenu", "()V", "deleteEmoji", "handleSaveAlias", "sanitizedName", "onSaveSuccess", ModelAuditLogEntry.CHANGE_KEY_NAME, "sanitizeEmojiName", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "", "emojiId", "J", "Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", "binding", "Ljava/lang/String;", "Lcom/discord/primitives/GuildId;", "guildId", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmojisEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEmojisEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex EMOJI_RE = new Regex("[^A-Za-z0-9_]");
    private static final String EXTRA_EMOJI_ALIAS = "EXTRA_EMOJI_ALIAS";
    private static final String EXTRA_EMOJI_ID = "EXTRA_EMOJI_ID";
    private static final String EXTRA_GUILD_ID = "EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long emojiId;
    private String emojiName;
    private long guildId;
    private final StatefulViews state;

    /* compiled from: WidgetServerSettingsEmojisEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojisEdit$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "emojiId", "", "alias", "", "create", "(Landroid/content/Context;JJLjava/lang/String;)V", "Lkotlin/text/Regex;", "EMOJI_RE", "Lkotlin/text/Regex;", WidgetServerSettingsEmojisEdit.EXTRA_EMOJI_ALIAS, "Ljava/lang/String;", WidgetServerSettingsEmojisEdit.EXTRA_EMOJI_ID, WidgetServerSettingsEmojisEdit.EXTRA_GUILD_ID, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId, long emojiId, String alias) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(alias, "alias");
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsEmojisEdit.EXTRA_GUILD_ID, guildId).putExtra(WidgetServerSettingsEmojisEdit.EXTRA_EMOJI_ID, emojiId).putExtra(WidgetServerSettingsEmojisEdit.EXTRA_EMOJI_ALIAS, alias);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…EXTRA_EMOJI_ALIAS, alias)");
            AppScreen2.d(context, WidgetServerSettingsEmojisEdit.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEmojisEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojisEdit$configureMenu$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_server_settings_emoji_delete) {
                return;
            }
            WidgetServerSettingsEmojisEdit.access$deleteEmoji(WidgetServerSettingsEmojisEdit.this);
        }
    }

    /* compiled from: WidgetServerSettingsEmojisEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojisEdit$deleteEmoji$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) throws Exception {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r5) throws Exception {
            StoreStream.INSTANCE.getGuildEmojis().deleteEmoji(WidgetServerSettingsEmojisEdit.access$getGuildId$p(WidgetServerSettingsEmojisEdit.this), WidgetServerSettingsEmojisEdit.access$getEmojiId$p(WidgetServerSettingsEmojisEdit.this));
            AppActivity appActivity = WidgetServerSettingsEmojisEdit.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetServerSettingsEmojisEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/emoji/ModelEmojiGuild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojisEdit$handleSaveAlias$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<ModelEmojiGuild> {
        public final /* synthetic */ String $sanitizedName;

        public AnonymousClass1(String str) {
            this.$sanitizedName = str;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelEmojiGuild modelEmojiGuild) {
            call2(modelEmojiGuild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelEmojiGuild modelEmojiGuild) {
            WidgetServerSettingsEmojisEdit.access$onSaveSuccess(WidgetServerSettingsEmojisEdit.this, this.$sanitizedName);
        }
    }

    /* compiled from: WidgetServerSettingsEmojisEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojisEdit$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEmojisEdit.access$handleSaveAlias(WidgetServerSettingsEmojisEdit.this);
        }
    }

    public WidgetServerSettingsEmojisEdit() {
        super(R.layout.widget_server_settings_emojis_edit);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEmojisEdit2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.server_settings_emojis_edit_alias);
        this.guildId = -1L;
        this.emojiId = -1L;
        this.emojiName = "";
    }

    public static final /* synthetic */ void access$deleteEmoji(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        widgetServerSettingsEmojisEdit.deleteEmoji();
    }

    public static final /* synthetic */ long access$getEmojiId$p(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        return widgetServerSettingsEmojisEdit.emojiId;
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        return widgetServerSettingsEmojisEdit.guildId;
    }

    public static final /* synthetic */ void access$handleSaveAlias(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        widgetServerSettingsEmojisEdit.handleSaveAlias();
    }

    public static final /* synthetic */ void access$onSaveSuccess(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit, String str) {
        widgetServerSettingsEmojisEdit.onSaveSuccess(str);
    }

    public static final /* synthetic */ void access$setEmojiId$p(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit, long j) {
        widgetServerSettingsEmojisEdit.emojiId = j;
    }

    public static final /* synthetic */ void access$setGuildId$p(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit, long j) {
        widgetServerSettingsEmojisEdit.guildId = j;
    }

    private final void configureMenu() {
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_server_settings_emojis_edit, new AnonymousClass1(), null, 4, null);
    }

    private final void configureToolbar(String emojiName) {
        setActionBarTitle(R.string.emoji);
        setActionBarSubtitle(emojiName);
    }

    public static final void create(Context context, long j, long j2, String str) {
        INSTANCE.create(context, j, j2, str);
    }

    private final void deleteEmoji() {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        StatefulViews.clear$default(this.state, false, 1, null);
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteGuildEmoji(this.guildId, this.emojiId), false, 1, null), this, null, 2, null).k(o.i(new AnonymousClass1(), this));
    }

    private final WidgetServerSettingsEmojisEditBinding getBinding() {
        return (WidgetServerSettingsEmojisEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleSaveAlias() {
        TextInputLayout textInputLayout = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsEmojisEditAlias");
        String strSanitizeEmojiName = sanitizeEmojiName(ViewExtensions.getTextOrEmpty(textInputLayout));
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().patchGuildEmoji(this.guildId, this.emojiId, new RestAPIParams.PatchGuildEmoji(strSanitizeEmojiName)), false, 1, null), this, null, 2, null).k(o.i(new AnonymousClass1(strSanitizeEmojiName), this));
    }

    private final void onSaveSuccess(String sanitizedName) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        configureToolbar(sanitizedName);
        StoreStream.INSTANCE.getGuildEmojis().fetchGuildEmoji(this.guildId);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsEmojisEditAlias");
        statefulViews.put(textInputLayout.getId(), sanitizedName);
        TextInputLayout textInputLayout2 = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsEmojisEditAlias");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout3 = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.serverSettingsEmojisEditAlias");
        ViewExtensions.setText(textInputLayout2, (CharSequence) statefulViews2.get(textInputLayout3.getId(), sanitizedName));
        AppToast.j(this, getString(R.string.save_media_success_mobile), 0, 4);
    }

    private final String sanitizeEmojiName(String name) {
        String strReplace = EMOJI_RE.replace(name, "");
        while (strReplace.length() < 2) {
            strReplace = strReplace + '_';
        }
        return strReplace;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.guildId = getMostRecentIntent().getLongExtra(EXTRA_GUILD_ID, -1L);
        this.emojiId = getMostRecentIntent().getLongExtra(EXTRA_EMOJI_ID, -1L);
        String stringExtra = getMostRecentIntent().getStringExtra(EXTRA_EMOJI_ALIAS);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.emojiName = stringExtra;
        TextInputLayout textInputLayout = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsEmojisEditAlias");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsEmojisEditAlias");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), this.emojiName));
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews2 = this.state;
        FloatingActionButton floatingActionButton = getBinding().c;
        TextInputLayout textInputLayout3 = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.serverSettingsEmojisEditAlias");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout3);
        this.state.configureSaveActionView(getBinding().c);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        configureToolbar(this.emojiName);
        configureMenu();
        if (getIsRecreated()) {
            return;
        }
        TextInputLayout textInputLayout4 = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.serverSettingsEmojisEditAlias");
        showKeyboard(textInputLayout4);
    }
}
