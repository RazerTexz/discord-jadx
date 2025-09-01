package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.auth.mfa.BackupCode;
import com.discord.api.auth.mfa.GetBackupCodesResponse;
import com.discord.api.auth.mfa.GetBackupCodesSendVerificationKeyRequestBody;
import com.discord.api.auth.mfa.GetBackupCodesSendVerificationKeyResponse;
import com.discord.api.auth.mfa.GetBackupCodesVerificationRequestBody;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountBackupCodesBinding;
import com.discord.databinding.WidgetSettingsItemBackupCodeBinding;
import com.discord.databinding.WidgetSettingsItemBackupCodeHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.notice.WidgetNoticeDialog;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetSettingsAccountBackupCodes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0004%&'$B\u0007¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u001d\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes;", "Lcom/discord/app/AppFragment;", "", "sendVerificationKey", "()V", "", "regenerate", "getBackupCodes", "(Z)V", "showPasswordModal", "showVerificationKeyModal", "", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "data", "configureUI", "(Ljava/util/List;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "", "verificationKey", "Ljava/lang/String;", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "nonce", "Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", "binding", "regenerateNonce", "Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$Adapter;", "backupCodesAdapter", "Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$Adapter;", "<init>", "Companion", "Adapter", "BackupCodeItem", "BackupCodeItemHeader", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccountBackupCodes.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Adapter backupCodesAdapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String nonce;
    private String password;
    private String regenerateNonce;
    private String verificationKey;

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "BackupCodeHeaderViewHolder", "BackupCodeViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {

        /* compiled from: WidgetSettingsAccountBackupCodes.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$Adapter$BackupCodeHeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetSettingsItemBackupCodeHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetSettingsItemBackupCodeHeaderBinding;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class BackupCodeHeaderViewHolder extends MGRecyclerViewHolder<Adapter, MGRecyclerDataPayload> {
            private final WidgetSettingsItemBackupCodeHeaderBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BackupCodeHeaderViewHolder(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                TextView textView = (TextView) view;
                WidgetSettingsItemBackupCodeHeaderBinding widgetSettingsItemBackupCodeHeaderBinding = new WidgetSettingsItemBackupCodeHeaderBinding(textView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetSettingsItemBackupCodeHeaderBinding, "WidgetSettingsItemBackup…derBinding.bind(itemView)");
                this.binding = widgetSettingsItemBackupCodeHeaderBinding;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
                onConfigure2(i, mGRecyclerDataPayload);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, MGRecyclerDataPayload data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                TextView textView = this.binding.f2624b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemHeader");
                textView.setText(((BackupCodeItemHeader) data).getHeaderText());
            }
        }

        /* compiled from: WidgetSettingsAccountBackupCodes.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$Adapter$BackupCodeViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetSettingsItemBackupCodeBinding;", "binding", "Lcom/discord/databinding/WidgetSettingsItemBackupCodeBinding;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class BackupCodeViewHolder extends MGRecyclerViewHolder<Adapter, MGRecyclerDataPayload> {
            private final WidgetSettingsItemBackupCodeBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BackupCodeViewHolder(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                TextView textView = (TextView) view;
                WidgetSettingsItemBackupCodeBinding widgetSettingsItemBackupCodeBinding = new WidgetSettingsItemBackupCodeBinding(textView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetSettingsItemBackupCodeBinding, "WidgetSettingsItemBackupCodeBinding.bind(itemView)");
                this.binding = widgetSettingsItemBackupCodeBinding;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
                onConfigure2(i, mGRecyclerDataPayload);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, MGRecyclerDataPayload data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                BackupCodeItem backupCodeItem = (BackupCodeItem) data;
                TextView textView = this.binding.f2623b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemBackupCodeTv");
                String code = backupCodeItem.getBackupCode().getCode();
                Objects.requireNonNull(code, "null cannot be cast to non-null type java.lang.String");
                String strSubstring = code.substring(0, 4);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String code2 = backupCodeItem.getBackupCode().getCode();
                Objects.requireNonNull(code2, "null cannot be cast to non-null type java.lang.String");
                String strSubstring2 = code2.substring(4);
                Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                FormatUtils.n(textView, R.string.backup_codes_dash, new Object[]{strSubstring, strSubstring2}, null, 4);
                if (backupCodeItem.getBackupCode().getConsumed()) {
                    this.binding.f2623b.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_brand_24dp, 0);
                    this.binding.f2623b.setOnClickListener(null);
                } else {
                    this.binding.f2623b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    this.binding.f2623b.setOnClickListener(new WidgetSettingsAccountBackupCodes6(data));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<Adapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return viewType != 0 ? viewType != 1 ? new MGRecyclerViewHolder<>(0, this) : new BackupCodeViewHolder(R.layout.widget_settings_item_backup_code, this) : new BackupCodeHeaderViewHolder(R.layout.widget_settings_item_backup_code_header, this);
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0018\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$BackupCodeItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/api/auth/mfa/BackupCode;", "component1", "()Lcom/discord/api/auth/mfa/BackupCode;", "backupCode", "copy", "(Lcom/discord/api/auth/mfa/BackupCode;)Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$BackupCodeItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/auth/mfa/BackupCode;", "getBackupCode", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/api/auth/mfa/BackupCode;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class BackupCodeItem implements MGRecyclerDataPayload {
        private final BackupCode backupCode;
        private final String key;
        private final int type;

        public BackupCodeItem(BackupCode backupCode) {
            Intrinsics3.checkNotNullParameter(backupCode, "backupCode");
            this.backupCode = backupCode;
            this.type = 1;
            this.key = backupCode.getCode();
        }

        public static /* synthetic */ BackupCodeItem copy$default(BackupCodeItem backupCodeItem, BackupCode backupCode, int i, Object obj) {
            if ((i & 1) != 0) {
                backupCode = backupCodeItem.backupCode;
            }
            return backupCodeItem.copy(backupCode);
        }

        /* renamed from: component1, reason: from getter */
        public final BackupCode getBackupCode() {
            return this.backupCode;
        }

        public final BackupCodeItem copy(BackupCode backupCode) {
            Intrinsics3.checkNotNullParameter(backupCode, "backupCode");
            return new BackupCodeItem(backupCode);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof BackupCodeItem) && Intrinsics3.areEqual(this.backupCode, ((BackupCodeItem) other).backupCode);
            }
            return true;
        }

        public final BackupCode getBackupCode() {
            return this.backupCode;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            BackupCode backupCode = this.backupCode;
            if (backupCode != null) {
                return backupCode.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("BackupCodeItem(backupCode=");
            sbU.append(this.backupCode);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$BackupCodeItemHeader;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "component1", "()Ljava/lang/CharSequence;", "headerText", "copy", "(Ljava/lang/CharSequence;)Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$BackupCodeItemHeader;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Ljava/lang/CharSequence;", "getHeaderText", "<init>", "(Ljava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class BackupCodeItemHeader implements MGRecyclerDataPayload {
        private final CharSequence headerText;
        private final String key;
        private final int type;

        public BackupCodeItemHeader(CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(charSequence, "headerText");
            this.headerText = charSequence;
            this.key = charSequence.toString();
        }

        public static /* synthetic */ BackupCodeItemHeader copy$default(BackupCodeItemHeader backupCodeItemHeader, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = backupCodeItemHeader.headerText;
            }
            return backupCodeItemHeader.copy(charSequence);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        public final BackupCodeItemHeader copy(CharSequence headerText) {
            Intrinsics3.checkNotNullParameter(headerText, "headerText");
            return new BackupCodeItemHeader(headerText);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof BackupCodeItemHeader) && Intrinsics3.areEqual(this.headerText, ((BackupCodeItemHeader) other).headerText);
            }
            return true;
        }

        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            CharSequence charSequence = this.headerText;
            if (charSequence != null) {
                return charSequence.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.E(outline.U("BackupCodeItemHeader(headerText="), this.headerText, ")");
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetSettingsAccountBackupCodes.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/auth/mfa/GetBackupCodesResponse;", "kotlin.jvm.PlatformType", "response", "", "invoke", "(Lcom/discord/api/auth/mfa/GetBackupCodesResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$getBackupCodes$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GetBackupCodesResponse, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GetBackupCodesResponse getBackupCodesResponse) {
            invoke2(getBackupCodesResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBackupCodesResponse getBackupCodesResponse) {
            List<BackupCode> listA = getBackupCodesResponse.a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listA) {
                if (!((BackupCode) obj).getConsumed()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : listA) {
                if (((BackupCode) obj2).getConsumed()) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            if (!arrayList.isEmpty()) {
                arrayList3.add(new BackupCodeItemHeader(FormatUtils.h(WidgetSettingsAccountBackupCodes.this.requireContext(), R.string.user_settings_available_codes, new Object[0], null, 4)));
                ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList4.add(new BackupCodeItem((BackupCode) it.next()));
                }
                arrayList3.addAll(arrayList4);
            }
            if (!arrayList2.isEmpty()) {
                arrayList3.add(new BackupCodeItemHeader(FormatUtils.h(WidgetSettingsAccountBackupCodes.this.requireContext(), R.string.user_settings_used_backup_codes, new Object[0], null, 4)));
                ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(new BackupCodeItem((BackupCode) it2.next()));
                }
                arrayList3.addAll(arrayList5);
            }
            WidgetSettingsAccountBackupCodes.access$configureUI(WidgetSettingsAccountBackupCodes.this, arrayList3);
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountBackupCodes.access$getBackupCodes(WidgetSettingsAccountBackupCodes.this, true);
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/auth/mfa/GetBackupCodesSendVerificationKeyResponse;", "kotlin.jvm.PlatformType", "response", "", "invoke", "(Lcom/discord/api/auth/mfa/GetBackupCodesSendVerificationKeyResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$sendVerificationKey$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GetBackupCodesSendVerificationKeyResponse, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GetBackupCodesSendVerificationKeyResponse getBackupCodesSendVerificationKeyResponse) {
            invoke2(getBackupCodesSendVerificationKeyResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBackupCodesSendVerificationKeyResponse getBackupCodesSendVerificationKeyResponse) {
            WidgetSettingsAccountBackupCodes.access$setNonce$p(WidgetSettingsAccountBackupCodes.this, getBackupCodesSendVerificationKeyResponse.getNonce());
            WidgetSettingsAccountBackupCodes.access$setRegenerateNonce$p(WidgetSettingsAccountBackupCodes.this, getBackupCodesSendVerificationKeyResponse.getRegenerateNonce());
            WidgetSettingsAccountBackupCodes.access$showVerificationKeyModal(WidgetSettingsAccountBackupCodes.this);
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$sendVerificationKey$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetSettingsAccountBackupCodes.access$showPasswordModal(WidgetSettingsAccountBackupCodes.this);
        }
    }

    public WidgetSettingsAccountBackupCodes() {
        super(R.layout.widget_settings_account_backup_codes);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountBackupCodes7.INSTANCE, null, 2, null);
        this.password = "";
        this.nonce = "";
        this.regenerateNonce = "";
        this.verificationKey = "";
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, List list) {
        widgetSettingsAccountBackupCodes.configureUI(list);
    }

    public static final /* synthetic */ void access$getBackupCodes(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, boolean z2) {
        widgetSettingsAccountBackupCodes.getBackupCodes(z2);
    }

    public static final /* synthetic */ String access$getNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.nonce;
    }

    public static final /* synthetic */ String access$getPassword$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.password;
    }

    public static final /* synthetic */ String access$getRegenerateNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.regenerateNonce;
    }

    public static final /* synthetic */ String access$getVerificationKey$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.verificationKey;
    }

    public static final /* synthetic */ void access$sendVerificationKey(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        widgetSettingsAccountBackupCodes.sendVerificationKey();
    }

    public static final /* synthetic */ void access$setNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.nonce = str;
    }

    public static final /* synthetic */ void access$setPassword$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.password = str;
    }

    public static final /* synthetic */ void access$setRegenerateNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.regenerateNonce = str;
    }

    public static final /* synthetic */ void access$setVerificationKey$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.verificationKey = str;
    }

    public static final /* synthetic */ void access$showPasswordModal(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        widgetSettingsAccountBackupCodes.showPasswordModal();
    }

    public static final /* synthetic */ void access$showVerificationKeyModal(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        widgetSettingsAccountBackupCodes.showVerificationKeyModal();
    }

    private final void configureUI(List<? extends MGRecyclerDataPayload> data) {
        Adapter adapter = this.backupCodesAdapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("backupCodesAdapter");
        }
        adapter.setData(data);
    }

    private final void getBackupCodes(boolean regenerate) {
        ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().getBackupCodesVerification(new GetBackupCodesVerificationRequestBody(this.verificationKey, regenerate ? this.regenerateNonce : this.nonce, regenerate)), this, null, 2, null), getBinding().f2590b, 100L), false, 1, null).k(o.a.g(getContext(), new AnonymousClass1(), null));
    }

    public static /* synthetic */ void getBackupCodes$default(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetSettingsAccountBackupCodes.getBackupCodes(z2);
    }

    private final WidgetSettingsAccountBackupCodesBinding getBinding() {
        return (WidgetSettingsAccountBackupCodesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendVerificationKey() {
        ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().getBackupCodesSendVerificationKey(new GetBackupCodesSendVerificationKeyRequestBody(this.password)), this, null, 2, null), false, 1, null).k(o.a.g(getContext(), new AnonymousClass1(), new AnonymousClass2()));
    }

    private final void showPasswordModal() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            CharSequence charSequenceH = FormatUtils.h(requireContext(), R.string.user_settings_enter_password_view_codes, new Object[0], null, 4);
            CharSequence charSequenceH2 = FormatUtils.h(requireContext(), R.string.form_label_password, new Object[0], null, 4);
            WidgetNoticeDialog.Companion.showInputModal$default(companion, appActivity, FormatUtils.h(requireContext(), R.string.two_fa_backup_codes_label, new Object[0], null, 4), charSequenceH, charSequenceH2, new WidgetSettingsAccountBackupCodes2(this), new WidgetSettingsAccountBackupCodes3(this), Boolean.FALSE, null, FormatUtils.h(requireContext(), R.string.two_fa_backup_codes_next_action, new Object[0], null, 4), false, 640, null);
        }
    }

    private final void showVerificationKeyModal() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            WidgetNoticeDialog.Companion.showInputModal$default(WidgetNoticeDialog.INSTANCE, appActivity, FormatUtils.h(requireContext(), R.string.two_fa_confirm_view_backup_codes_label, new Object[0], null, 4), FormatUtils.h(requireContext(), R.string.two_fa_confirm_view_backup_codes_body, new Object[0], null, 4), FormatUtils.h(requireContext(), R.string.two_fa_confirm_view_backup_codes_input_label, new Object[0], null, 4), new WidgetSettingsAccountBackupCodes4(this), new WidgetSettingsAccountBackupCodes5(this), Boolean.FALSE, StoreNotices.InputDialog.Type.TEXT_NO_SUGGESTIONS, null, true, 256, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.two_fa_backup_codes_label);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsBackupCodesInfo");
        FormatUtils.n(textView, R.string.two_fa_backup_codes_body, new Object[0], null, 4);
        RecyclerView recyclerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.settingsBackupCodesRv");
        this.backupCodesAdapter = new Adapter(recyclerView);
        if (getActivity() != null) {
            MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
            RecyclerView recyclerView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.settingsBackupCodesRv");
            this.backupCodesAdapter = (Adapter) companion.configure(new Adapter(recyclerView2));
        }
        getBinding().c.setOnClickListener(new AnonymousClass2());
        getBinding().f2590b.setDimmed(true, true);
        showPasswordModal();
    }
}
