package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.widget.NestedScrollView;
import b.a.i.ViewRadioButtonBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGuildInviteBottomSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.views.CheckedSetting;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: ViewInviteSettingsSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00019B\u0011\b\u0016\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103B\u0019\b\u0016\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\b2\u00106B!\b\u0016\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u00020\n¢\u0006\u0004\b2\u00108J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J3\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006:"}, d2 = {"Lcom/discord/widgets/guilds/invite/ViewInviteSettingsSheet;", "Landroidx/core/widget/NestedScrollView;", "", "setOnItemSelected", "()V", "Landroid/widget/RadioGroup;", "radioGroup", "", "valueSet", "Lkotlin/Function1;", "", "", "textFactory", "createHorizontalCheckableButtons", "(Landroid/widget/RadioGroup;[ILkotlin/jvm/functions/Function1;)V", "numUses", "", "getMaxUsesString", "(I)Ljava/lang/String;", "Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "data", "configureUi", "(Lcom/discord/widgets/guilds/invite/WidgetInviteModel;)V", "Lcom/discord/models/domain/ModelInvite$Settings;", "updateSettings", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/widgets/guilds/invite/ViewInviteSettingsSheet$ChannelsSpinnerAdapter;", "channelsSpinnerAdapter", "Lcom/discord/widgets/guilds/invite/ViewInviteSettingsSheet$ChannelsSpinnerAdapter;", "Lcom/discord/databinding/ViewGuildInviteBottomSheetBinding;", "binding", "Lcom/discord/databinding/ViewGuildInviteBottomSheetBinding;", "pendingInviteSettings", "Lcom/discord/models/domain/ModelInvite$Settings;", "Lkotlin/Function0;", "onGenerateLinkListener", "Lkotlin/jvm/functions/Function0;", "getOnGenerateLinkListener", "()Lkotlin/jvm/functions/Function0;", "setOnGenerateLinkListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel;", "viewModel", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel;", "getViewModel", "()Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel;", "setViewModel", "(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel;)V", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ChannelsSpinnerAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ViewInviteSettingsSheet extends NestedScrollView {
    private final ViewGuildInviteBottomSheetBinding binding;
    private final ChannelsSpinnerAdapter channelsSpinnerAdapter;
    private Function0<Unit> onGenerateLinkListener;
    private ModelInvite.Settings pendingInviteSettings;
    private Function1<? super ModelInvite.Settings, Unit> updateSettings;
    public WidgetGuildInviteShareViewModel viewModel;

    /* compiled from: ViewInviteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "expirationTime", "", "invoke", "(I)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, CharSequence> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharSequence invoke(int i) {
            Context context = ViewInviteSettingsSheet.this.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            return DurationUtils3.formatInviteExpireAfterString(context, i);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(I)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Integer, String> {
        public AnonymousClass2(ViewInviteSettingsSheet viewInviteSettingsSheet) {
            super(1, viewInviteSettingsSheet, ViewInviteSettingsSheet.class, "getMaxUsesString", "getMaxUsesString(I)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final String invoke(int i) {
            return ViewInviteSettingsSheet.access$getMaxUsesString((ViewInviteSettingsSheet) this.receiver, i);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018¢\u0006\u0004\b!\u0010\"J1\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u001b\u0010\u001a\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/discord/widgets/guilds/invite/ViewInviteSettingsSheet$ChannelsSpinnerAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/discord/api/channel/Channel;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "layoutId", "Landroid/view/View;", "convertView", "", "dropDownMode", "getItemView", "(IILandroid/view/View;Z)Landroid/view/View;", "", "setupViews", "(Landroid/view/View;IZ)V", "getCount", "()I", "getItem", "(I)Lcom/discord/api/channel/Channel;", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "getDropDownView", "", "newData", "setData", "([Lcom/discord/api/channel/Channel;)V", "channels", "[Lcom/discord/api/channel/Channel;", "Landroid/content/Context;", "context", "textViewResourceId", "<init>", "(Landroid/content/Context;I[Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelsSpinnerAdapter extends ArrayAdapter<Channel> {
        private Channel[] channels;

        public /* synthetic */ ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, i, (i2 & 4) != 0 ? new Channel[0] : channelArr);
        }

        private final View getItemView(int position, int layoutId, View convertView, boolean dropDownMode) {
            if (convertView == null) {
                convertView = View.inflate(getContext(), layoutId, null);
            }
            Intrinsics3.checkNotNullExpressionValue(convertView, "view");
            setupViews(convertView, position, dropDownMode);
            return convertView;
        }

        private final void setupViews(View convertView, int position, boolean dropDownMode) {
            TextView textView = (TextView) convertView.findViewById(new ViewInviteSettingsSheet2(dropDownMode).invoke2());
            Intrinsics3.checkNotNullExpressionValue(textView, "label");
            String str = String.format("#%s", Arrays.copyOf(new Object[]{ChannelUtils.c(this.channels[position])}, 1));
            Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            textView.setText(str);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.channels.length;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return getItemView(position, R.layout.view_invite_settngs_channel_spinner_item_open, convertView, true);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int i) {
            return getItem(i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return getItemView(position, R.layout.view_invite_settings_channel_spinner_item, convertView, false);
        }

        public final void setData(Channel[] newData) {
            Intrinsics3.checkNotNullParameter(newData, "newData");
            this.channels = newData;
            notifyDataSetChanged();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr) {
            super(context, i, channelArr);
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(channelArr, "channels");
            this.channels = channelArr;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Channel getItem(int position) {
            return this.channels[position];
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public final /* synthetic */ WidgetInviteModel $data;

        public AnonymousClass10(WidgetInviteModel widgetInviteModel) {
            this.$data = widgetInviteModel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(ViewInviteSettingsSheet.this);
            if (settingsAccess$getPendingInviteSettings$p != null) {
                ViewInviteSettingsSheet.this.getViewModel().updateInviteSettings(settingsAccess$getPendingInviteSettings$p);
            }
            Channel targetChannel = this.$data.getTargetChannel();
            if (targetChannel != null) {
                ViewInviteSettingsSheet.this.getViewModel().generateInviteLink(Long.valueOf(targetChannel.getId()).longValue());
            }
            ViewInviteSettingsSheet.this.getOnGenerateLinkListener().invoke();
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "checkedId", "", "onCheckedChanged", "(Landroid/widget/RadioGroup;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$4, reason: invalid class name */
    public static final class AnonymousClass4 implements RadioGroup.OnCheckedChangeListener {
        public AnonymousClass4() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
            ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, settingsAccess$getPendingInviteSettings$p != null ? settingsAccess$getPendingInviteSettings$p.mergeMaxAge(i) : null);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "checkedId", "", "onCheckedChanged", "(Landroid/widget/RadioGroup;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$8, reason: invalid class name */
    public static final class AnonymousClass8 implements RadioGroup.OnCheckedChangeListener {
        public AnonymousClass8() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
            ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, settingsAccess$getPendingInviteSettings$p != null ? settingsAccess$getPendingInviteSettings$p.mergeMaxUses(i) : null);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite.Settings settingsMergeTemporary;
            ViewInviteSettingsSheet.access$getBinding$p(ViewInviteSettingsSheet.this).f.toggle();
            ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
            if (settingsAccess$getPendingInviteSettings$p != null) {
                CheckedSetting checkedSetting = ViewInviteSettingsSheet.access$getBinding$p(ViewInviteSettingsSheet.this).f;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
                settingsMergeTemporary = settingsAccess$getPendingInviteSettings$p.mergeTemporary(checkedSetting.isChecked());
            } else {
                settingsMergeTemporary = null;
            }
            ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, settingsMergeTemporary);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/discord/widgets/guilds/invite/ViewInviteSettingsSheet$setOnItemSelected$1", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", ModelAuditLogEntry.CHANGE_KEY_ID, "", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$setOnItemSelected$1, reason: invalid class name */
    public static final class AnonymousClass1 implements AdapterView.OnItemSelectedListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            Intrinsics3.checkNotNullParameter(view, "view");
            ViewInviteSettingsSheet.this.getViewModel().selectChannel(ViewInviteSettingsSheet.access$getChannelsSpinnerAdapter$p(ViewInviteSettingsSheet.this).getItem(position).getId());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "ctx");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingA = ViewGuildInviteBottomSheetBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingA, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingA;
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet4.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet3.INSTANCE;
        setFocusable(true);
        setContentDescription(FormatUtils.j(this, R.string.invite_settings_title, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingA.f2190b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new AnonymousClass1());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingA.e;
        Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new AnonymousClass2(this));
        setOnItemSelected();
    }

    public static final /* synthetic */ ViewGuildInviteBottomSheetBinding access$getBinding$p(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        return viewInviteSettingsSheet.binding;
    }

    public static final /* synthetic */ ChannelsSpinnerAdapter access$getChannelsSpinnerAdapter$p(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        return viewInviteSettingsSheet.channelsSpinnerAdapter;
    }

    public static final /* synthetic */ String access$getMaxUsesString(ViewInviteSettingsSheet viewInviteSettingsSheet, int i) {
        return viewInviteSettingsSheet.getMaxUsesString(i);
    }

    public static final /* synthetic */ ModelInvite.Settings access$getPendingInviteSettings$p(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        return viewInviteSettingsSheet.pendingInviteSettings;
    }

    public static final /* synthetic */ void access$setPendingInviteSettings$p(ViewInviteSettingsSheet viewInviteSettingsSheet, ModelInvite.Settings settings) {
        viewInviteSettingsSheet.pendingInviteSettings = settings;
    }

    @MainThread
    private final void createHorizontalCheckableButtons(RadioGroup radioGroup, int[] valueSet, Function1<? super Integer, ? extends CharSequence> textFactory) {
        if (radioGroup.getChildCount() > 0) {
            return;
        }
        boolean z2 = false;
        for (int i : valueSet) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_radio_button, (ViewGroup) radioGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            RadioButton radioButton = (RadioButton) viewInflate;
            Intrinsics3.checkNotNullExpressionValue(new ViewRadioButtonBinding(radioButton), "ViewRadioButtonBinding.i…text), radioGroup, false)");
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.root");
            radioButton.setId(i);
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.root");
            radioButton.setText(textFactory.invoke(Integer.valueOf(i)));
            if (!z2) {
                Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.root");
                ViewGroup.LayoutParams layoutParams = radioButton.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
                RadioGroup.LayoutParams layoutParams2 = (RadioGroup.LayoutParams) layoutParams;
                layoutParams2.leftMargin = DimenUtils.dpToPixels(16);
                Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.root");
                radioButton.setLayoutParams(layoutParams2);
                z2 = true;
            }
            radioGroup.addView(radioButton);
        }
    }

    private final String getMaxUsesString(int numUses) {
        return numUses != 0 ? String.valueOf(numUses) : "∞";
    }

    private final void setOnItemSelected() {
        Spinner spinner = this.binding.f2190b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setOnItemSelectedListener(new AnonymousClass1());
    }

    public final void configureUi(WidgetInviteModel data) {
        Object obj;
        Object next;
        Intrinsics3.checkNotNullParameter(data, "data");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = this.channelsSpinnerAdapter;
        Object[] array = data.getInvitableChannels().toArray(new Channel[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        channelsSpinnerAdapter.setData((Channel[]) array);
        Iterator<Channel> it = data.getInvitableChannels().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Channel next2 = it.next();
            Channel targetChannel = data.getTargetChannel();
            if (targetChannel != null && targetChannel.getId() == next2.getId()) {
                break;
            } else {
                i++;
            }
        }
        this.binding.f2190b.setSelection(Math.max(i, 0), false);
        ModelInvite.Settings settings = data.getSettings();
        if (settings != null) {
            this.pendingInviteSettings = settings;
            RadioGroup radioGroup = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
            Ranges2 ranges2Until = _Ranges.until(0, radioGroup.getChildCount());
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
            Iterator<Integer> it2 = ranges2Until.iterator();
            while (it2.hasNext()) {
                View childAt = this.binding.c.getChildAt(((Iterators4) it2).nextInt());
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
                arrayList.add((RadioButton) childAt);
            }
            Iterator it3 = arrayList.iterator();
            while (true) {
                obj = null;
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
                int id2 = ((RadioButton) next).getId();
                ModelInvite.Settings settings2 = this.pendingInviteSettings;
                if (settings2 != null && id2 == settings2.getMaxAge()) {
                    break;
                }
            }
            RadioButton radioButton = (RadioButton) next;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
            this.binding.c.setOnCheckedChangeListener(new AnonymousClass4());
            RadioGroup radioGroup2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
            Ranges2 ranges2Until2 = _Ranges.until(0, radioGroup2.getChildCount());
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until2, 10));
            Iterator<Integer> it4 = ranges2Until2.iterator();
            while (it4.hasNext()) {
                View childAt2 = this.binding.e.getChildAt(((Iterators4) it4).nextInt());
                Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.widget.RadioButton");
                arrayList2.add((RadioButton) childAt2);
            }
            Iterator it5 = arrayList2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next3 = it5.next();
                int id3 = ((RadioButton) next3).getId();
                ModelInvite.Settings settings3 = this.pendingInviteSettings;
                if (settings3 != null && id3 == settings3.getMaxUses()) {
                    obj = next3;
                    break;
                }
            }
            RadioButton radioButton2 = (RadioButton) obj;
            if (radioButton2 != null) {
                radioButton2.setChecked(true);
            }
            this.binding.e.setOnCheckedChangeListener(new AnonymousClass8());
            CheckedSetting checkedSetting = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
            ModelInvite.Settings settings4 = this.pendingInviteSettings;
            checkedSetting.setChecked(settings4 != null ? settings4.isTemporary() : false);
            this.binding.f.e(new AnonymousClass9());
            this.binding.d.setOnClickListener(new AnonymousClass10(data));
        }
    }

    public final Function0<Unit> getOnGenerateLinkListener() {
        return this.onGenerateLinkListener;
    }

    public final WidgetGuildInviteShareViewModel getViewModel() {
        WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel = this.viewModel;
        if (widgetGuildInviteShareViewModel == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("viewModel");
        }
        return widgetGuildInviteShareViewModel;
    }

    public final void setOnGenerateLinkListener(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onGenerateLinkListener = function0;
    }

    public final void setViewModel(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        Intrinsics3.checkNotNullParameter(widgetGuildInviteShareViewModel, "<set-?>");
        this.viewModel = widgetGuildInviteShareViewModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "ctx");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrSet");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingA = ViewGuildInviteBottomSheetBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingA, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingA;
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet4.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet3.INSTANCE;
        setFocusable(true);
        setContentDescription(FormatUtils.j(this, R.string.invite_settings_title, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingA.f2190b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new AnonymousClass1());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingA.e;
        Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new AnonymousClass2(this));
        setOnItemSelected();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "ctx");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrSet");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingA = ViewGuildInviteBottomSheetBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingA, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingA;
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet4.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet3.INSTANCE;
        setFocusable(true);
        setContentDescription(FormatUtils.j(this, R.string.invite_settings_title, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingA.f2190b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new AnonymousClass1());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingA.e;
        Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new AnonymousClass2(this));
        setOnItemSelected();
    }
}
