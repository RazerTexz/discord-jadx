package com.discord.widgets.chat.input.autocomplete;

import a0.a.a.b;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.MetricAffectingSpan;
import android.text.style.StyleSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppLog;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommand3;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.User;
import com.discord.stores.CommandAutocompleteState;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreApplicationCommandFrecency;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.FontColorSpan;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import com.discord.widgets.chat.AutocompleteUtils;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.WidgetChatInputAutocompleteStickerAdapter2;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel4;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel5;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel6;
import com.discord.widgets.chat.input.autocomplete.InputEditTextAction;
import com.discord.widgets.chat.input.autocomplete.commands.AutocompleteCommandUtils;
import com.discord.widgets.chat.input.emoji.EmojiAutocompletePremiumUpsellFeatureFlag;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.AutocompleteApplicationCommands;
import com.discord.widgets.chat.input.models.AutocompleteInputModel;
import com.discord.widgets.chat.input.models.AutocompleteInputSelectionModel;
import com.discord.widgets.chat.input.models.ChatInputMentionsMap;
import com.discord.widgets.chat.input.models.CommandOptionValue;
import com.discord.widgets.chat.input.models.InputCommandContext;
import com.discord.widgets.chat.input.models.InputSelectionModel;
import com.discord.widgets.chat.input.models.InputSelectionModel2;
import com.discord.widgets.chat.input.models.MentionInputModel;
import com.discord.widgets.chat.input.models.MentionToken;
import com.discord.widgets.chat.input.models.OptionRange;
import com.lytefast.flexinput.model.Attachment;
import d0.d0._Ranges;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0._Strings;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._CollectionsJvm;
import d0.t._Sets;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import f0.e0.Util7;
import j0.k.Func1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: AutocompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Ù\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\bÙ\u0001Ú\u0001Û\u0001Ü\u0001Bp\u0012\u0013\b\u0002\u0010Ï\u0001\u001a\f\u0018\u00010\u008b\u0001j\u0005\u0018\u0001`Î\u0001\u0012\b\u0010É\u0001\u001a\u00030È\u0001\u0012\n\b\u0002\u0010¼\u0001\u001a\u00030»\u0001\u0012\b\u0010Ô\u0001\u001a\u00030Ó\u0001\u0012\t\b\u0001\u0010²\u0001\u001a\u00020\\\u0012\t\b\u0001\u0010µ\u0001\u001a\u00020\\\u0012\t\b\u0001\u0010\u009e\u0001\u001a\u00020\\\u0012\u000f\b\u0002\u0010Ö\u0001\u001a\b\u0012\u0004\u0012\u00020\f0W¢\u0006\u0006\b×\u0001\u0010Ø\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0019\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020'2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010)J#\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0004\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b$\u0010+J!\u0010-\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b-\u0010.J#\u0010/\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b/\u00100J#\u00101\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b1\u00100J=\u0010;\u001a\u00020:2\u0006\u00103\u001a\u0002022\f\u00106\u001a\b\u0012\u0004\u0012\u000205042\f\u00108\u001a\b\u0012\u0004\u0012\u000207042\b\b\u0002\u00109\u001a\u00020,H\u0002¢\u0006\u0004\b;\u0010<J/\u0010B\u001a\u00020A2\u0006\u0010\t\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u00102\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00100?H\u0002¢\u0006\u0004\bB\u0010CJ)\u0010G\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00142\b\u0010E\u001a\u0004\u0018\u00010\u00142\u0006\u0010F\u001a\u00020\u0016H\u0002¢\u0006\u0004\bG\u0010HJ\u0019\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010F\u001a\u00020\u0016H\u0002¢\u0006\u0004\bJ\u0010KJ\u001f\u0010M\u001a\u00020\u00052\u0006\u0010L\u001a\u0002022\u0006\u0010F\u001a\u00020\u0016H\u0003¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020A2\u0006\u0010\t\u001a\u00020\u001dH\u0003¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0014H\u0003¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0014H\u0003¢\u0006\u0004\bS\u0010RJ\u0017\u0010U\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u0010H\u0002¢\u0006\u0004\bU\u0010\u0013J\u000f\u0010V\u001a\u00020\u0005H\u0003¢\u0006\u0004\bV\u0010\"J\u0013\u0010X\u001a\b\u0012\u0004\u0012\u00020A0W¢\u0006\u0004\bX\u0010YJ\u0013\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0W¢\u0006\u0004\b[\u0010YJ/\u0010`\u001a\u00020A2\u0006\u0010D\u001a\u00020\u00142\u0006\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020\\2\u0006\u0010_\u001a\u00020\\H\u0007¢\u0006\u0004\b`\u0010aJ!\u0010e\u001a\u00020A2\u0006\u0010c\u001a\u00020b2\b\u0010d\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\be\u0010fJ%\u0010h\u001a\u00020\u00052\u0006\u0010D\u001a\u0002022\u0006\u0010]\u001a\u00020\\2\u0006\u0010g\u001a\u00020\\¢\u0006\u0004\bh\u0010iJ\u0017\u0010k\u001a\u00020\u00052\u0006\u0010j\u001a\u000205H\u0007¢\u0006\u0004\bk\u0010lJ\u0017\u0010m\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\bm\u0010\u0013J\u0017\u0010p\u001a\u00020\u00052\u0006\u0010o\u001a\u00020nH\u0007¢\u0006\u0004\bp\u0010qJ\u001b\u0010t\u001a\u0004\u0018\u00010s2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bt\u0010uJ\u001d\u0010x\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030w0v¢\u0006\u0004\bx\u0010yJ\u0015\u0010|\u001a\u00020{2\u0006\u0010z\u001a\u000202¢\u0006\u0004\b|\u0010}J\r\u0010~\u001a\u00020\u0005¢\u0006\u0004\b~\u0010\"J\u001e\u0010\u0080\u0001\u001a\u00020\u00052\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020504¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u000f\u0010\u0082\u0001\u001a\u00020\u0005¢\u0006\u0005\b\u0082\u0001\u0010\"J\u001d\u0010\u0084\u0001\u001a\u00020\u00052\u000b\u0010\u0083\u0001\u001a\u0006\u0012\u0002\b\u00030w¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001d\u0010\u0086\u0001\u001a\u00020\u00052\u000b\u0010\u0083\u0001\u001a\u0006\u0012\u0002\b\u00030w¢\u0006\u0006\b\u0086\u0001\u0010\u0085\u0001J\u0012\u0010\u0087\u0001\u001a\u00020:H\u0007¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J.\u0010\u008d\u0001\u001a\u0014\u0012\n\u0012\b0\u008b\u0001j\u0003`\u008c\u0001\u0012\u0004\u0012\u00020\\0v2\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001H\u0007¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001a\u0010\u0091\u0001\u001a\u00020\u00052\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J+\u0010\u0096\u0001\u001a\u00020\u00052\u0007\u0010\u0093\u0001\u001a\u00020\\2\u0007\u0010\u0094\u0001\u001a\u00020\\2\u0007\u0010\u0095\u0001\u001a\u00020\\¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001R)\u0010\u0098\u0001\u001a\u00020\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001e\u0010\u009e\u0001\u001a\u00020\\8\u0006@\u0006¢\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u0099\u0001\u001a\u0006\b\u009f\u0001\u0010\u009b\u0001RB\u0010¢\u0001\u001a+\u0012\r\u0012\u000b ¡\u0001*\u0004\u0018\u00010A0A ¡\u0001*\u0014\u0012\r\u0012\u000b ¡\u0001*\u0004\u0018\u00010A0A\u0018\u00010 \u00010 \u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001b\u0010¤\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001RB\u0010¦\u0001\u001a+\u0012\r\u0012\u000b ¡\u0001*\u0004\u0018\u00010\u001d0\u001d ¡\u0001*\u0014\u0012\r\u0012\u000b ¡\u0001*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010 \u00010 \u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010£\u0001R(\u0010d\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bd\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0005\bª\u0001\u0010\u000fR\u001b\u0010«\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R'\u0010c\u001a\u00020b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bc\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u001e\u0010²\u0001\u001a\u00020\\8\u0006@\u0006¢\u0006\u0010\n\u0006\b²\u0001\u0010\u0099\u0001\u001a\u0006\b³\u0001\u0010\u009b\u0001RB\u0010´\u0001\u001a+\u0012\r\u0012\u000b ¡\u0001*\u0004\u0018\u00010\b0\b ¡\u0001*\u0014\u0012\r\u0012\u000b ¡\u0001*\u0004\u0018\u00010\b0\b\u0018\u00010 \u00010 \u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b´\u0001\u0010£\u0001R\u001e\u0010µ\u0001\u001a\u00020\\8\u0006@\u0006¢\u0006\u0010\n\u0006\bµ\u0001\u0010\u0099\u0001\u001a\u0006\b¶\u0001\u0010\u009b\u0001R\u001e\u0010·\u0001\u001a\u00020,8\u0006@\u0006¢\u0006\u0010\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001R\u001f\u0010¼\u0001\u001a\u00030»\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001RF\u0010Á\u0001\u001a/\u0012\u000f\u0012\r ¡\u0001*\u0005\u0018\u00010À\u00010À\u0001 ¡\u0001*\u0016\u0012\u000f\u0012\r ¡\u0001*\u0005\u0018\u00010À\u00010À\u0001\u0018\u00010 \u00010 \u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010£\u0001R\u0019\u0010Â\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010¸\u0001R\u001b\u0010Ã\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R*\u0010Æ\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030w0Å\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u001f\u0010É\u0001\u001a\u00030È\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001RB\u0010Í\u0001\u001a+\u0012\r\u0012\u000b ¡\u0001*\u0004\u0018\u00010Z0Z ¡\u0001*\u0014\u0012\r\u0012\u000b ¡\u0001*\u0004\u0018\u00010Z0Z\u0018\u00010 \u00010 \u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÍ\u0001\u0010£\u0001R(\u0010Ï\u0001\u001a\f\u0018\u00010\u008b\u0001j\u0005\u0018\u0001`Î\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÏ\u0001\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u001a\u0010Ô\u0001\u001a\u00030Ó\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001¨\u0006Ý\u0001"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/chat/input/autocomplete/ViewState;", "Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "newModel", "", "handleInputSelectionModel", "(Lcom/discord/widgets/chat/input/models/InputSelectionModel;)V", "Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;", "model", "handleAutocompleteInputSelectionModel", "(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)V", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;", "newState", "handleStoreState", "(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;)V", "Lcom/discord/models/commands/ApplicationCommandOption;", "applicationCommandsOption", "selectAttachmentOption", "(Lcom/discord/models/commands/ApplicationCommandOption;)V", "", "currentInput", "Lcom/discord/api/channel/Channel;", "oldChannel", "newChannel", "handleNewChannel", "(Ljava/lang/CharSequence;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)V", "Lkotlin/ranges/IntRange;", "selection", "Lcom/discord/widgets/chat/input/models/MentionInputModel;", "inputModel", "handleSelectionWithInputModel", "(Lkotlin/ranges/IntRange;Lcom/discord/widgets/chat/input/models/MentionInputModel;)Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "onCommandCleared", "()V", "Lcom/discord/models/commands/ApplicationCommand;", "newSelectedCommand", "onNewCommandSelected", "(Lcom/discord/models/commands/ApplicationCommand;)V", "Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;", "getSelectedCommandViewState", "(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;", "oldModel", "(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)Lcom/discord/models/commands/ApplicationCommand;", "", "commandCleared", "(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)Z", "newSelectedCommandOption", "(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)Lcom/discord/models/commands/ApplicationCommandOption;", "hasAddedAttachmentOption", "", "token", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "autocompletables", "Lcom/discord/widgets/chat/input/AutocompleteStickerItem;", "stickers", "isAutocompletable", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "getAutocompleteViewState", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Z)Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;", "selectedOption", "", "showError", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "applyCommandOptionSpans", "(Lcom/discord/widgets/chat/input/models/MentionInputModel$VerifiedCommandInputModel;Lcom/discord/models/commands/ApplicationCommandOption;Ljava/util/Set;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "input", "previousInput", "channel", "checkForCommandsToQuery", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/discord/api/channel/Channel;)V", "Lcom/discord/models/user/User;", "getChannelBot", "(Lcom/discord/api/channel/Channel;)Lcom/discord/models/user/User;", "commandPrefix", "queryCommandsFromCommandPrefixToken", "(Ljava/lang/String;Lcom/discord/api/channel/Channel;)V", "generateSpanUpdates", "(Lcom/discord/widgets/chat/input/models/MentionInputModel;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "onPreAutocompleteCompute", "(Ljava/lang/CharSequence;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "replacementSpanCommandParamDeletion", "commandOption", "removeAttachment", "selectFirstInvalidCommandOption", "Lrx/Observable;", "observeEditTextActions", "()Lrx/Observable;", "Lcom/discord/widgets/chat/input/autocomplete/Event;", "observeEvents", "", "start", "before", "count", "onInputTextChanged", "(Ljava/lang/CharSequence;III)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$InputState;", "inputState", "storeState", "onDataUpdated", "(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$InputState;Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;)Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "finish", "onSelectionChanged", "(Ljava/lang/String;II)V", "autocompletable", "selectAutocompleteItem", "(Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;)V", "selectCommandOption", "Lcom/discord/api/sticker/Sticker;", "sticker", "selectStickerItem", "(Lcom/discord/api/sticker/Sticker;)V", "focusedOption", "Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "getApplicationSendData", "(Lcom/discord/models/commands/ApplicationCommandOption;)Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "", "Lcom/lytefast/flexinput/model/Attachment;", "getCommandAttachments", "()Ljava/util/Map;", "content", "Lcom/discord/widgets/chat/MessageContent;", "replaceAutocompletableDataWithServerValues", "(Ljava/lang/String;)Lcom/discord/widgets/chat/MessageContent;", "onApplicationCommandSendError", "visibleItems", "checkEmojiAutocompleteUpsellViewed", "(Ljava/util/List;)V", "onAutocompleteItemsUpdated", "attachment", "onAttachmentRemoved", "(Lcom/lytefast/flexinput/model/Attachment;)V", "setAttachment", "getApplicationCommandsBrowserViewState", "()Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "discoveryCommands", "", "Lcom/discord/primitives/ApplicationId;", "getCommandBrowserCommandPositions", "(Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;)Ljava/util/Map;", "Lcom/discord/models/commands/Application;", "application", "selectCommandBrowserApplication", "(Lcom/discord/models/commands/Application;)V", "firstVisibleItemPosition", "lastVisibleItemPosition", "totalItems", "onCommandsBrowserScroll", "(III)V", "lastJumpedSequenceId", "I", "getLastJumpedSequenceId", "()I", "setLastJumpedSequenceId", "(I)V", "commandOptionErrorColor", "getCommandOptionErrorColor", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "editTextAction", "Lrx/subjects/BehaviorSubject;", "lastChatInputModel", "Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "inputMentionModelSubject", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;", "getStoreState", "()Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;", "setStoreState", "selectedOptionForAttachment", "Lcom/discord/models/commands/ApplicationCommandOption;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$InputState;", "getInputState", "()Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$InputState;", "setInputState", "(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$InputState;)V", "defaultMentionColor", "getDefaultMentionColor", "autocompleteInputSelectionModelSubject", "defaultCommandOptionBackgroundColor", "getDefaultCommandOptionBackgroundColor", "emojiAutocompleteUpsellEnabled", "Z", "getEmojiAutocompleteUpsellEnabled", "()Z", "Lcom/discord/stores/StoreApplicationCommands;", "storeApplicationCommands", "Lcom/discord/stores/StoreApplicationCommands;", "getStoreApplicationCommands", "()Lcom/discord/stores/StoreApplicationCommands;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$SelectionState;", "inputSelectionSubject", "logEmojiAutocompleteUpsellViewed", "lastAutocompleteInputSelectionModel", "Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;", "", "commandAttachments", "Ljava/util/Map;", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "getFlexInputViewModel", "()Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "events", "Lcom/discord/primitives/ChannelId;", "channelId", "Ljava/lang/Long;", "getChannelId", "()Ljava/lang/Long;", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreExperiments;", "storeObservable", "<init>", "(Ljava/lang/Long;Lcom/discord/widgets/chat/input/AppFlexInputViewModel;Lcom/discord/stores/StoreApplicationCommands;Lcom/discord/stores/StoreExperiments;IIILrx/Observable;)V", "Companion", "InputState", "SelectionState", "StoreState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AutocompleteViewModel extends AppViewModel<AutocompleteViewModel7> {
    public static final String COMMAND_DISCOVER_TOKEN = "/";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_PLACEHOLDER_COUNT = 3;
    private final BehaviorSubject<AutocompleteInputSelectionModel> autocompleteInputSelectionModelSubject;
    private final Long channelId;
    private final Map<ApplicationCommandOption, Attachment<?>> commandAttachments;
    private final int commandOptionErrorColor;
    private final int defaultCommandOptionBackgroundColor;
    private final int defaultMentionColor;
    private final BehaviorSubject<InputEditTextAction> editTextAction;
    private final boolean emojiAutocompleteUpsellEnabled;
    private final BehaviorSubject<AutocompleteViewModel5> events;
    private final AppFlexInputViewModel flexInputViewModel;
    private final BehaviorSubject<MentionInputModel> inputMentionModelSubject;
    private final BehaviorSubject<SelectionState> inputSelectionSubject;
    private InputState inputState;
    private AutocompleteInputSelectionModel lastAutocompleteInputSelectionModel;
    private InputSelectionModel lastChatInputModel;
    private int lastJumpedSequenceId;
    private boolean logEmojiAutocompleteUpsellViewed;
    private ApplicationCommandOption selectedOptionForAttachment;
    private final StoreApplicationCommands storeApplicationCommands;
    private final StoreExperiments storeExperiments;
    private StoreState storeState;

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Throwable> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger.e$default(AppLog.g, "Autocomplete Store Error", th, null, 4, null);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/models/commands/ApplicationCommandOption;", "", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$10, reason: invalid class name */
    public static final class AnonymousClass10<T> implements Action1<Tuples2<? extends ApplicationCommandOption, ? extends String>> {
        public AnonymousClass10() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Tuples2<? extends ApplicationCommandOption, ? extends String> tuples2) {
            call2((Tuples2<ApplicationCommandOption, String>) tuples2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Tuples2<ApplicationCommandOption, String> tuples2) {
            AutocompleteViewModel.this.getStoreApplicationCommands().setAutocompleteLoading(tuples2.getFirst().getName(), tuples2.getSecond());
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/models/commands/ApplicationCommandOption;", "", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$11, reason: invalid class name */
    public static final class AnonymousClass11 extends Lambda implements Function1<Tuples2<? extends ApplicationCommandOption, ? extends String>, Unit> {
        public AnonymousClass11() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends ApplicationCommandOption, ? extends String> tuples2) {
            invoke2((Tuples2<ApplicationCommandOption, String>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<ApplicationCommandOption, String> tuples2) {
            AutocompleteViewModel.access$getEvents$p(AutocompleteViewModel.this).onNext(new AutocompleteViewModel5.RequestAutocompleteData(tuples2.getFirst()));
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$12, reason: invalid class name */
    public static final class AnonymousClass12<T, R> implements Func1<AutocompleteInputSelectionModel, String> {
        public static final AnonymousClass12 INSTANCE = new AnonymousClass12();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ String call(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            return call2(autocompleteInputSelectionModel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final String call2(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            MentionToken autocompleteToken = autocompleteInputSelectionModel.getAutocompleteToken();
            if (autocompleteToken != null) {
                return autocompleteToken.getToken();
            }
            return null;
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass2(AutocompleteViewModel autocompleteViewModel) {
            super(1, autocompleteViewModel, AutocompleteViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            AutocompleteViewModel.access$handleStoreState((AutocompleteViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$SelectionState;", "kotlin.jvm.PlatformType", "selection", "Lcom/discord/widgets/chat/input/models/MentionInputModel;", "inputModel", "Lcom/discord/widgets/chat/input/models/InputSelectionModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$SelectionState;Lcom/discord/widgets/chat/input/models/MentionInputModel;)Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, R> implements Func2<SelectionState, MentionInputModel, InputSelectionModel> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ InputSelectionModel call(SelectionState selectionState, MentionInputModel mentionInputModel) {
            return call2(selectionState, mentionInputModel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final InputSelectionModel call2(SelectionState selectionState, MentionInputModel mentionInputModel) {
            if (!Intrinsics3.areEqual(selectionState.getInput(), mentionInputModel.getInput().toString())) {
                return null;
            }
            AutocompleteViewModel autocompleteViewModel = AutocompleteViewModel.this;
            Ranges2 selection = selectionState.getSelection();
            Intrinsics3.checkNotNullExpressionValue(mentionInputModel, "inputModel");
            return AutocompleteViewModel.access$handleSelectionWithInputModel(autocompleteViewModel, selection, mentionInputModel);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$4, reason: invalid class name */
    public static final class AnonymousClass4<T> implements Action1<Throwable> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger.e$default(AppLog.g, "Autocomplete Input Selection Model Error", th, null, 4, null);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/models/InputSelectionModel;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/models/InputSelectionModel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$5, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<InputSelectionModel, Unit> {
        public AnonymousClass5(AutocompleteViewModel autocompleteViewModel) {
            super(1, autocompleteViewModel, AutocompleteViewModel.class, "handleInputSelectionModel", "handleInputSelectionModel(Lcom/discord/widgets/chat/input/models/InputSelectionModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InputSelectionModel inputSelectionModel) throws IOException {
            invoke2(inputSelectionModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InputSelectionModel inputSelectionModel) throws IOException {
            Intrinsics3.checkNotNullParameter(inputSelectionModel, "p1");
            AutocompleteViewModel.access$handleInputSelectionModel((AutocompleteViewModel) this.receiver, inputSelectionModel);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$6, reason: invalid class name */
    public static final class AnonymousClass6<T> implements Action1<Throwable> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger.e$default(AppLog.g, "Full Autocomplete Model Error", th, null, 4, null);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$7, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<AutocompleteInputSelectionModel, Unit> {
        public AnonymousClass7(AutocompleteViewModel autocompleteViewModel) {
            super(1, autocompleteViewModel, AutocompleteViewModel.class, "handleAutocompleteInputSelectionModel", "handleAutocompleteInputSelectionModel(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            invoke2(autocompleteInputSelectionModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            Intrinsics3.checkNotNullParameter(autocompleteInputSelectionModel, "p1");
            AutocompleteViewModel.access$handleAutocompleteInputSelectionModel((AutocompleteViewModel) this.receiver, autocompleteInputSelectionModel);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$8, reason: invalid class name */
    public static final class AnonymousClass8<T> implements Action1<Throwable> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger.e$default(AppLog.g, "Full Autocomplete Model Error", th, null, 4, null);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;", "kotlin.jvm.PlatformType", "it", "Lkotlin/Pair;", "Lcom/discord/models/commands/ApplicationCommandOption;", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$9, reason: invalid class name */
    public static final class AnonymousClass9<T, R> implements Func1<AutocompleteInputSelectionModel, Tuples2<? extends ApplicationCommandOption, ? extends String>> {
        public static final AnonymousClass9 INSTANCE = new AnonymousClass9();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Tuples2<? extends ApplicationCommandOption, ? extends String> call(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            return call2(autocompleteInputSelectionModel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<ApplicationCommandOption, String> call2(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            ApplicationCommandOption selectedCommandOption;
            InputSelectionModel inputSelectionModel = autocompleteInputSelectionModel.getInputSelectionModel();
            if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
                inputSelectionModel = null;
            }
            InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
            if (commandInputSelectionModel == null || (selectedCommandOption = commandInputSelectionModel.getSelectedCommandOption()) == null || !selectedCommandOption.getAutocomplete()) {
                return null;
            }
            CommandOptionValue commandOptionValue = commandInputSelectionModel.getInputModel().getInputCommandOptionValues().get(selectedCommandOption);
            return new Tuples2<>(selectedCommandOption, String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null));
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "inputChannelId", "Lcom/discord/stores/StoreApplicationCommands;", "storeApplicationCommands", "Lcom/discord/stores/StoreApplicationCommandFrecency;", "storeApplicationCommandsFrecency", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;", "observeStores", "(Ljava/lang/Long;Lcom/discord/stores/StoreApplicationCommands;Lcom/discord/stores/StoreApplicationCommandFrecency;)Lrx/Observable;", "", "COMMAND_DISCOVER_TOKEN", "Ljava/lang/String;", "", "DEFAULT_PLACEHOLDER_COUNT", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, Long l, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
            return companion.observeStores(l, storeApplicationCommands, storeApplicationCommandFrecency);
        }

        private final Observable<StoreState> observeStores(Long inputChannelId, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandsFrecency) {
            Observable observableG;
            if (inputChannelId != null) {
                observableG = StoreStream.INSTANCE.getChannels().observeChannel(inputChannelId.longValue()).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            } else {
                observableG = StoreStream.INSTANCE.getChannelsSelected().observeSelectedChannel().y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            }
            Observable<StoreState> observableY = observableG.Y(new AutocompleteViewModel2(storeApplicationCommands, storeApplicationCommandsFrecency));
            Intrinsics3.checkNotNullExpressionValue(observableY, "inputChannel.switchMap {…      )\n        }\n      }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJb\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\bHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R%\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010\rR2\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010$\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010(R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b*\u0010\u0010R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b.\u0010\u0007¨\u00061"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$InputState;", "", "", "component1", "()Ljava/lang/CharSequence;", "Lcom/discord/models/commands/ApplicationCommand;", "component2", "()Lcom/discord/models/commands/ApplicationCommand;", "", "", "Lcom/discord/primitives/ApplicationId;", "", "component3", "()Ljava/util/Map;", "Lcom/discord/models/commands/ApplicationCommandOption;", "component4", "()Lcom/discord/models/commands/ApplicationCommandOption;", "Lkotlin/ranges/IntRange;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "component5", "currentInput", "selectedCommand", "applicationsPosition", "showErrorForOption", "inputAutocompleteMap", "copy", "(Ljava/lang/CharSequence;Lcom/discord/models/commands/ApplicationCommand;Ljava/util/Map;Lcom/discord/models/commands/ApplicationCommandOption;Ljava/util/Map;)Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$InputState;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getInputAutocompleteMap", "getApplicationsPosition", "setApplicationsPosition", "(Ljava/util/Map;)V", "Lcom/discord/models/commands/ApplicationCommandOption;", "getShowErrorForOption", "Ljava/lang/CharSequence;", "getCurrentInput", "Lcom/discord/models/commands/ApplicationCommand;", "getSelectedCommand", "<init>", "(Ljava/lang/CharSequence;Lcom/discord/models/commands/ApplicationCommand;Ljava/util/Map;Lcom/discord/models/commands/ApplicationCommandOption;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class InputState {
        private Map<Long, Integer> applicationsPosition;
        private final CharSequence currentInput;
        private final Map<Ranges2, Autocompletable> inputAutocompleteMap;
        private final ApplicationCommand selectedCommand;
        private final ApplicationCommandOption showErrorForOption;

        public InputState() {
            this(null, null, null, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public InputState(CharSequence charSequence, ApplicationCommand applicationCommand, Map<Long, Integer> map, ApplicationCommandOption applicationCommandOption, Map<Ranges2, ? extends Autocompletable> map2) {
            Intrinsics3.checkNotNullParameter(charSequence, "currentInput");
            Intrinsics3.checkNotNullParameter(map, "applicationsPosition");
            Intrinsics3.checkNotNullParameter(map2, "inputAutocompleteMap");
            this.currentInput = charSequence;
            this.selectedCommand = applicationCommand;
            this.applicationsPosition = map;
            this.showErrorForOption = applicationCommandOption;
            this.inputAutocompleteMap = map2;
        }

        public static /* synthetic */ InputState copy$default(InputState inputState, CharSequence charSequence, ApplicationCommand applicationCommand, Map map, ApplicationCommandOption applicationCommandOption, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = inputState.currentInput;
            }
            if ((i & 2) != 0) {
                applicationCommand = inputState.selectedCommand;
            }
            ApplicationCommand applicationCommand2 = applicationCommand;
            if ((i & 4) != 0) {
                map = inputState.applicationsPosition;
            }
            Map map3 = map;
            if ((i & 8) != 0) {
                applicationCommandOption = inputState.showErrorForOption;
            }
            ApplicationCommandOption applicationCommandOption2 = applicationCommandOption;
            if ((i & 16) != 0) {
                map2 = inputState.inputAutocompleteMap;
            }
            return inputState.copy(charSequence, applicationCommand2, map3, applicationCommandOption2, map2);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getCurrentInput() {
            return this.currentInput;
        }

        /* renamed from: component2, reason: from getter */
        public final ApplicationCommand getSelectedCommand() {
            return this.selectedCommand;
        }

        public final Map<Long, Integer> component3() {
            return this.applicationsPosition;
        }

        /* renamed from: component4, reason: from getter */
        public final ApplicationCommandOption getShowErrorForOption() {
            return this.showErrorForOption;
        }

        public final Map<Ranges2, Autocompletable> component5() {
            return this.inputAutocompleteMap;
        }

        public final InputState copy(CharSequence currentInput, ApplicationCommand selectedCommand, Map<Long, Integer> applicationsPosition, ApplicationCommandOption showErrorForOption, Map<Ranges2, ? extends Autocompletable> inputAutocompleteMap) {
            Intrinsics3.checkNotNullParameter(currentInput, "currentInput");
            Intrinsics3.checkNotNullParameter(applicationsPosition, "applicationsPosition");
            Intrinsics3.checkNotNullParameter(inputAutocompleteMap, "inputAutocompleteMap");
            return new InputState(currentInput, selectedCommand, applicationsPosition, showErrorForOption, inputAutocompleteMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputState)) {
                return false;
            }
            InputState inputState = (InputState) other;
            return Intrinsics3.areEqual(this.currentInput, inputState.currentInput) && Intrinsics3.areEqual(this.selectedCommand, inputState.selectedCommand) && Intrinsics3.areEqual(this.applicationsPosition, inputState.applicationsPosition) && Intrinsics3.areEqual(this.showErrorForOption, inputState.showErrorForOption) && Intrinsics3.areEqual(this.inputAutocompleteMap, inputState.inputAutocompleteMap);
        }

        public final Map<Long, Integer> getApplicationsPosition() {
            return this.applicationsPosition;
        }

        public final CharSequence getCurrentInput() {
            return this.currentInput;
        }

        public final Map<Ranges2, Autocompletable> getInputAutocompleteMap() {
            return this.inputAutocompleteMap;
        }

        public final ApplicationCommand getSelectedCommand() {
            return this.selectedCommand;
        }

        public final ApplicationCommandOption getShowErrorForOption() {
            return this.showErrorForOption;
        }

        public int hashCode() {
            CharSequence charSequence = this.currentInput;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            ApplicationCommand applicationCommand = this.selectedCommand;
            int iHashCode2 = (iHashCode + (applicationCommand != null ? applicationCommand.hashCode() : 0)) * 31;
            Map<Long, Integer> map = this.applicationsPosition;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            ApplicationCommandOption applicationCommandOption = this.showErrorForOption;
            int iHashCode4 = (iHashCode3 + (applicationCommandOption != null ? applicationCommandOption.hashCode() : 0)) * 31;
            Map<Ranges2, Autocompletable> map2 = this.inputAutocompleteMap;
            return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
        }

        public final void setApplicationsPosition(Map<Long, Integer> map) {
            Intrinsics3.checkNotNullParameter(map, "<set-?>");
            this.applicationsPosition = map;
        }

        public String toString() {
            StringBuilder sbU = outline.U("InputState(currentInput=");
            sbU.append(this.currentInput);
            sbU.append(", selectedCommand=");
            sbU.append(this.selectedCommand);
            sbU.append(", applicationsPosition=");
            sbU.append(this.applicationsPosition);
            sbU.append(", showErrorForOption=");
            sbU.append(this.showErrorForOption);
            sbU.append(", inputAutocompleteMap=");
            return outline.M(sbU, this.inputAutocompleteMap, ")");
        }

        public /* synthetic */ InputState(String str, ApplicationCommand applicationCommand, Map map, ApplicationCommandOption applicationCommandOption, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : applicationCommand, (i & 4) != 0 ? new HashMap() : map, (i & 8) == 0 ? applicationCommandOption : null, (i & 16) != 0 ? Maps6.emptyMap() : map2);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$SelectionState;", "", "", "component1", "()Ljava/lang/String;", "Lkotlin/ranges/IntRange;", "component2", "()Lkotlin/ranges/IntRange;", "input", "selection", "copy", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$SelectionState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getInput", "Lkotlin/ranges/IntRange;", "getSelection", "<init>", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SelectionState {
        private final String input;
        private final Ranges2 selection;

        public SelectionState(String str, Ranges2 ranges2) {
            Intrinsics3.checkNotNullParameter(str, "input");
            Intrinsics3.checkNotNullParameter(ranges2, "selection");
            this.input = str;
            this.selection = ranges2;
        }

        public static /* synthetic */ SelectionState copy$default(SelectionState selectionState, String str, Ranges2 ranges2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = selectionState.input;
            }
            if ((i & 2) != 0) {
                ranges2 = selectionState.selection;
            }
            return selectionState.copy(str, ranges2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getInput() {
            return this.input;
        }

        /* renamed from: component2, reason: from getter */
        public final Ranges2 getSelection() {
            return this.selection;
        }

        public final SelectionState copy(String input, Ranges2 selection) {
            Intrinsics3.checkNotNullParameter(input, "input");
            Intrinsics3.checkNotNullParameter(selection, "selection");
            return new SelectionState(input, selection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectionState)) {
                return false;
            }
            SelectionState selectionState = (SelectionState) other;
            return Intrinsics3.areEqual(this.input, selectionState.input) && Intrinsics3.areEqual(this.selection, selectionState.selection);
        }

        public final String getInput() {
            return this.input;
        }

        public final Ranges2 getSelection() {
            return this.selection;
        }

        public int hashCode() {
            String str = this.input;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Ranges2 ranges2 = this.selection;
            return iHashCode + (ranges2 != null ? ranges2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SelectionState(input=");
            sbU.append(this.input);
            sbU.append(", selection=");
            sbU.append(this.selection);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B·\u0001\u0012\n\u0010\u001f\u001a\u00060\u0002j\u0002`\u0003\u0012\u0010\u0010 \u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006\u0012\u0006\u0010!\u001a\u00020\n\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0012 \b\u0002\u0010$\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0011\u0012\u001a\b\u0002\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0011\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001a\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0004\bC\u0010DJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\tJ(\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0011HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0015J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\tJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\tJÆ\u0001\u0010)\u001a\u00020\u00002\f\b\u0002\u0010\u001f\u001a\u00060\u0002j\u0002`\u00032\u0012\b\u0002\u0010 \u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u00062\b\b\u0002\u0010!\u001a\u00020\n2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062 \b\u0002\u0010$\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u00112\u001a\b\u0002\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001a2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u0006HÆ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u001a\u00102\u001a\u0002012\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b2\u00103R+\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00118\u0006@\u0006¢\u0006\f\n\u0004\b%\u00104\u001a\u0004\b5\u0010\u0015R\u0019\u0010!\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00106\u001a\u0004\b7\u0010\fR\u001d\u0010\u001f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u0005R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u00068\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010:\u001a\u0004\b;\u0010\tR\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010:\u001a\u0004\b<\u0010\tR\u001b\u0010&\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010=\u001a\u0004\b>\u0010\u001cR1\u0010$\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u00118\u0006@\u0006¢\u0006\f\n\u0004\b$\u00104\u001a\u0004\b?\u0010\u0015R\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010:\u001a\u0004\b@\u0010\tR\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010:\u001a\u0004\bA\u0010\tR#\u0010 \u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b \u0010:\u001a\u0004\bB\u0010\t¨\u0006E"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;", "", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "", "Lcom/discord/primitives/RoleId;", "component2", "()Ljava/util/List;", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/commands/ApplicationCommand;", "component4", "Lcom/discord/models/commands/Application;", "component5", "", "", "Lcom/discord/stores/CommandAutocompleteState;", "component6", "()Ljava/util/Map;", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "component7", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "component8", "()Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "component9", "component10", "userId", "userRoles", "channel", "queriedCommands", "applications", "commandOptionAutocompleteItems", "autocompletables", "browserCommands", "frecencyCommandIds", "frecencyCommands", "copy", "(JLjava/util/List;Lcom/discord/api/channel/Channel;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;Ljava/util/List;Ljava/util/List;)Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getAutocompletables", "Lcom/discord/api/channel/Channel;", "getChannel", "J", "getUserId", "Ljava/util/List;", "getFrecencyCommandIds", "getApplications", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "getBrowserCommands", "getCommandOptionAutocompleteItems", "getFrecencyCommands", "getQueriedCommands", "getUserRoles", "<init>", "(JLjava/util/List;Lcom/discord/api/channel/Channel;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;Ljava/util/List;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final List<Application> applications;
        private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
        private final WidgetChatInputDiscoveryCommandsModel browserCommands;
        private final Channel channel;
        private final Map<String, Map<String, CommandAutocompleteState>> commandOptionAutocompleteItems;
        private final List<String> frecencyCommandIds;
        private final List<ApplicationCommand> frecencyCommands;
        private final List<ApplicationCommand> queriedCommands;
        private final long userId;
        private final List<Long> userRoles;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(long j, List<Long> list, Channel channel, List<? extends ApplicationCommand> list2, List<Application> list3, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<String> list4, List<? extends ApplicationCommand> list5) {
            Intrinsics3.checkNotNullParameter(list, "userRoles");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(list2, "queriedCommands");
            Intrinsics3.checkNotNullParameter(list3, "applications");
            Intrinsics3.checkNotNullParameter(map, "commandOptionAutocompleteItems");
            Intrinsics3.checkNotNullParameter(map2, "autocompletables");
            Intrinsics3.checkNotNullParameter(list4, "frecencyCommandIds");
            Intrinsics3.checkNotNullParameter(list5, "frecencyCommands");
            this.userId = j;
            this.userRoles = list;
            this.channel = channel;
            this.queriedCommands = list2;
            this.applications = list3;
            this.commandOptionAutocompleteItems = map;
            this.autocompletables = map2;
            this.browserCommands = widgetChatInputDiscoveryCommandsModel;
            this.frecencyCommandIds = list4;
            this.frecencyCommands = list5;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, long j, List list, Channel channel, List list2, List list3, Map map, Map map2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List list4, List list5, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.userId : j, (i & 2) != 0 ? storeState.userRoles : list, (i & 4) != 0 ? storeState.channel : channel, (i & 8) != 0 ? storeState.queriedCommands : list2, (i & 16) != 0 ? storeState.applications : list3, (i & 32) != 0 ? storeState.commandOptionAutocompleteItems : map, (i & 64) != 0 ? storeState.autocompletables : map2, (i & 128) != 0 ? storeState.browserCommands : widgetChatInputDiscoveryCommandsModel, (i & 256) != 0 ? storeState.frecencyCommandIds : list4, (i & 512) != 0 ? storeState.frecencyCommands : list5);
        }

        /* renamed from: component1, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        public final List<ApplicationCommand> component10() {
            return this.frecencyCommands;
        }

        public final List<Long> component2() {
            return this.userRoles;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final List<ApplicationCommand> component4() {
            return this.queriedCommands;
        }

        public final List<Application> component5() {
            return this.applications;
        }

        public final Map<String, Map<String, CommandAutocompleteState>> component6() {
            return this.commandOptionAutocompleteItems;
        }

        public final Map<LeadingIdentifier, Set<Autocompletable>> component7() {
            return this.autocompletables;
        }

        /* renamed from: component8, reason: from getter */
        public final WidgetChatInputDiscoveryCommandsModel getBrowserCommands() {
            return this.browserCommands;
        }

        public final List<String> component9() {
            return this.frecencyCommandIds;
        }

        public final StoreState copy(long userId, List<Long> userRoles, Channel channel, List<? extends ApplicationCommand> queriedCommands, List<Application> applications, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> commandOptionAutocompleteItems, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> autocompletables, WidgetChatInputDiscoveryCommandsModel browserCommands, List<String> frecencyCommandIds, List<? extends ApplicationCommand> frecencyCommands) {
            Intrinsics3.checkNotNullParameter(userRoles, "userRoles");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(queriedCommands, "queriedCommands");
            Intrinsics3.checkNotNullParameter(applications, "applications");
            Intrinsics3.checkNotNullParameter(commandOptionAutocompleteItems, "commandOptionAutocompleteItems");
            Intrinsics3.checkNotNullParameter(autocompletables, "autocompletables");
            Intrinsics3.checkNotNullParameter(frecencyCommandIds, "frecencyCommandIds");
            Intrinsics3.checkNotNullParameter(frecencyCommands, "frecencyCommands");
            return new StoreState(userId, userRoles, channel, queriedCommands, applications, commandOptionAutocompleteItems, autocompletables, browserCommands, frecencyCommandIds, frecencyCommands);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.userId == storeState.userId && Intrinsics3.areEqual(this.userRoles, storeState.userRoles) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.queriedCommands, storeState.queriedCommands) && Intrinsics3.areEqual(this.applications, storeState.applications) && Intrinsics3.areEqual(this.commandOptionAutocompleteItems, storeState.commandOptionAutocompleteItems) && Intrinsics3.areEqual(this.autocompletables, storeState.autocompletables) && Intrinsics3.areEqual(this.browserCommands, storeState.browserCommands) && Intrinsics3.areEqual(this.frecencyCommandIds, storeState.frecencyCommandIds) && Intrinsics3.areEqual(this.frecencyCommands, storeState.frecencyCommands);
        }

        public final List<Application> getApplications() {
            return this.applications;
        }

        public final Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
            return this.autocompletables;
        }

        public final WidgetChatInputDiscoveryCommandsModel getBrowserCommands() {
            return this.browserCommands;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<String, Map<String, CommandAutocompleteState>> getCommandOptionAutocompleteItems() {
            return this.commandOptionAutocompleteItems;
        }

        public final List<String> getFrecencyCommandIds() {
            return this.frecencyCommandIds;
        }

        public final List<ApplicationCommand> getFrecencyCommands() {
            return this.frecencyCommands;
        }

        public final List<ApplicationCommand> getQueriedCommands() {
            return this.queriedCommands;
        }

        public final long getUserId() {
            return this.userId;
        }

        public final List<Long> getUserRoles() {
            return this.userRoles;
        }

        public int hashCode() {
            int iA = b.a(this.userId) * 31;
            List<Long> list = this.userRoles;
            int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            List<ApplicationCommand> list2 = this.queriedCommands;
            int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<Application> list3 = this.applications;
            int iHashCode4 = (iHashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
            Map<String, Map<String, CommandAutocompleteState>> map = this.commandOptionAutocompleteItems;
            int iHashCode5 = (iHashCode4 + (map != null ? map.hashCode() : 0)) * 31;
            Map<LeadingIdentifier, Set<Autocompletable>> map2 = this.autocompletables;
            int iHashCode6 = (iHashCode5 + (map2 != null ? map2.hashCode() : 0)) * 31;
            WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel = this.browserCommands;
            int iHashCode7 = (iHashCode6 + (widgetChatInputDiscoveryCommandsModel != null ? widgetChatInputDiscoveryCommandsModel.hashCode() : 0)) * 31;
            List<String> list4 = this.frecencyCommandIds;
            int iHashCode8 = (iHashCode7 + (list4 != null ? list4.hashCode() : 0)) * 31;
            List<ApplicationCommand> list5 = this.frecencyCommands;
            return iHashCode8 + (list5 != null ? list5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(userId=");
            sbU.append(this.userId);
            sbU.append(", userRoles=");
            sbU.append(this.userRoles);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", queriedCommands=");
            sbU.append(this.queriedCommands);
            sbU.append(", applications=");
            sbU.append(this.applications);
            sbU.append(", commandOptionAutocompleteItems=");
            sbU.append(this.commandOptionAutocompleteItems);
            sbU.append(", autocompletables=");
            sbU.append(this.autocompletables);
            sbU.append(", browserCommands=");
            sbU.append(this.browserCommands);
            sbU.append(", frecencyCommandIds=");
            sbU.append(this.frecencyCommandIds);
            sbU.append(", frecencyCommands=");
            return outline.L(sbU, this.frecencyCommands, ")");
        }

        public /* synthetic */ StoreState(long j, List list, Channel channel, List list2, List list3, Map map, Map map2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List list4, List list5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, list, channel, (i & 8) != 0 ? Collections2.emptyList() : list2, (i & 16) != 0 ? Collections2.emptyList() : list3, (i & 32) != 0 ? Maps6.emptyMap() : map, (i & 64) != 0 ? Maps6.emptyMap() : map2, (i & 128) != 0 ? null : widgetChatInputDiscoveryCommandsModel, (i & 256) != 0 ? Collections2.emptyList() : list4, (i & 512) != 0 ? Collections2.emptyList() : list5);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationCommandType.values();
            int[] iArr = new int[12];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationCommandType.USER.ordinal()] = 1;
            iArr[ApplicationCommandType.CHANNEL.ordinal()] = 2;
            iArr[ApplicationCommandType.ROLE.ordinal()] = 3;
            iArr[ApplicationCommandType.MENTIONABLE.ordinal()] = 4;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutocompleteViewModel(Long l, AppFlexInputViewModel appFlexInputViewModel, StoreApplicationCommands storeApplicationCommands, StoreExperiments storeExperiments, int i, int i2, int i3, Observable observable, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        Long l2 = (i4 & 1) != 0 ? null : l;
        StoreApplicationCommands applicationCommands = (i4 & 4) != 0 ? StoreStream.INSTANCE.getApplicationCommands() : storeApplicationCommands;
        if ((i4 & 128) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStores = Companion.access$observeStores(companion, l2, companion2.getApplicationCommands(), companion2.getApplicationComandFrecency());
        } else {
            observableAccess$observeStores = observable;
        }
        this(l2, appFlexInputViewModel, applicationCommands, storeExperiments, i, i2, i3, observableAccess$observeStores);
    }

    public static final /* synthetic */ BehaviorSubject access$getEvents$p(AutocompleteViewModel autocompleteViewModel) {
        return autocompleteViewModel.events;
    }

    public static final /* synthetic */ void access$handleAutocompleteInputSelectionModel(AutocompleteViewModel autocompleteViewModel, AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
        autocompleteViewModel.handleAutocompleteInputSelectionModel(autocompleteInputSelectionModel);
    }

    public static final /* synthetic */ void access$handleInputSelectionModel(AutocompleteViewModel autocompleteViewModel, InputSelectionModel inputSelectionModel) throws IOException {
        autocompleteViewModel.handleInputSelectionModel(inputSelectionModel);
    }

    public static final /* synthetic */ InputSelectionModel access$handleSelectionWithInputModel(AutocompleteViewModel autocompleteViewModel, Ranges2 ranges2, MentionInputModel mentionInputModel) {
        return autocompleteViewModel.handleSelectionWithInputModel(ranges2, mentionInputModel);
    }

    public static final /* synthetic */ void access$handleStoreState(AutocompleteViewModel autocompleteViewModel, StoreState storeState) {
        autocompleteViewModel.handleStoreState(storeState);
    }

    private final InputEditTextAction applyCommandOptionSpans(MentionInputModel.VerifiedCommandInputModel model, ApplicationCommandOption selectedOption, Set<ApplicationCommandOption> showError) {
        Object value;
        AutocompleteViewModel autocompleteViewModel = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ApplicationCommandOption applicationCommandOption : model.getInputCommandOptionsRanges().keySet()) {
            boolean z2 = !showError.contains(applicationCommandOption);
            OptionRange optionRange = model.getInputCommandOptionsRanges().get(applicationCommandOption);
            if (optionRange != null) {
                int last = optionRange.getParam().getLast();
                if (!Intrinsics3.areEqual(selectedOption, applicationCommandOption)) {
                    last = optionRange.getValue().getLast();
                }
                int i = last;
                int i2 = autocompleteViewModel.defaultCommandOptionBackgroundColor;
                String string = null;
                Integer numValueOf = !z2 ? Integer.valueOf(autocompleteViewModel.commandOptionErrorColor) : null;
                CommandOptionValue commandOptionValue = model.getInputCommandOptionValues().get(applicationCommandOption);
                if (commandOptionValue != null && (value = commandOptionValue.getValue()) != null) {
                    string = value.toString();
                }
                linkedHashMap.put(new Ranges2(optionRange.getParam().getFirst(), i), CollectionsJVM.listOf(new ApplicationCommandSpan(applicationCommandOption, string, optionRange.getParam().getFirst(), i, DimenUtils.dpToPixels(4), DimenUtils.dpToPixels(4), i2, DimenUtils.dpToPixels(4), numValueOf, false, AutocompleteViewModel3.INSTANCE, 512, null)));
            }
            autocompleteViewModel = this;
        }
        return new InputEditTextAction.ReplacePillSpans(model.getInput(), linkedHashMap);
    }

    private final void checkForCommandsToQuery(CharSequence input, CharSequence previousInput, Channel channel) {
        AutocompleteCommandUtils autocompleteCommandUtils = AutocompleteCommandUtils.INSTANCE;
        String commandPrefix = autocompleteCommandUtils.getCommandPrefix(input);
        String commandPrefix2 = previousInput != null ? autocompleteCommandUtils.getCommandPrefix(previousInput) : null;
        if (commandPrefix == null || !(!Intrinsics3.areEqual(commandPrefix, commandPrefix2))) {
            return;
        }
        queryCommandsFromCommandPrefixToken((String) Strings4.split$default((CharSequence) commandPrefix, new String[]{" "}, false, 0, 6, (Object) null).get(0), channel);
    }

    private final boolean commandCleared(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        MentionInputModel.VerifiedCommandInputModel inputModel;
        InputCommandContext inputCommandContext;
        MentionInputModel.VerifiedCommandInputModel inputModel2;
        InputCommandContext inputCommandContext2;
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        ApplicationCommand selectedCommand = (commandInputSelectionModel == null || (inputModel2 = commandInputSelectionModel.getInputModel()) == null || (inputCommandContext2 = inputModel2.getInputCommandContext()) == null) ? null : inputCommandContext2.getSelectedCommand();
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel2;
        ApplicationCommand selectedCommand2 = (commandInputSelectionModel2 == null || (inputModel = commandInputSelectionModel2.getInputModel()) == null || (inputCommandContext = inputModel.getInputCommandContext()) == null) ? null : inputCommandContext.getSelectedCommand();
        if ((selectedCommand != null ? selectedCommand.getId() : null) == null) {
            if ((selectedCommand2 != null ? selectedCommand2.getId() : null) != null) {
                return true;
            }
        }
        return false;
    }

    @MainThread
    private final InputEditTextAction generateSpanUpdates(MentionInputModel model) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Ranges2, Autocompletable> entry : model.getInputMentionsMap().entrySet()) {
            Ranges2 key = entry.getKey();
            Autocompletable value = entry.getValue();
            if (!(value instanceof ApplicationCommandAutocompletable)) {
                if (!(value instanceof RoleAutocompletable)) {
                    value = null;
                }
                RoleAutocompletable roleAutocompletable = (RoleAutocompletable) value;
                linkedHashMap.put(key, Collections2.listOf((Object[]) new MetricAffectingSpan[]{new FontColorSpan(RoleUtils.getOpaqueColor(roleAutocompletable != null ? roleAutocompletable.getRole() : null, this.defaultMentionColor)), new StyleSpan(1)}));
            }
        }
        return new InputEditTextAction.ReplaceCharacterStyleSpans(model.getInput(), linkedHashMap);
    }

    public static /* synthetic */ ApplicationCommandData getApplicationSendData$default(AutocompleteViewModel autocompleteViewModel, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommandOption = null;
        }
        return autocompleteViewModel.getApplicationSendData(applicationCommandOption);
    }

    private final AutocompleteViewModel4 getAutocompleteViewState(String token, List<? extends Autocompletable> autocompletables, List<WidgetChatInputAutocompleteStickerAdapter2> stickers, boolean isAutocompletable) {
        List mutableList = _Collections.toMutableList((Collection) autocompletables);
        if (this.emojiAutocompleteUpsellEnabled) {
            boolean reducedMotionEnabled = StoreStream.INSTANCE.getAccessibility().getReducedMotionEnabled();
            List listFilterIsInstance = _CollectionsJvm.filterIsInstance(autocompletables, EmojiAutocompletable.class);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listFilterIsInstance) {
                if (!((EmojiAutocompletable) obj).getEmoji().isUsable()) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                List listTake = _Collections.take(arrayList, 3);
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listTake, 10));
                Iterator it = listTake.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((EmojiAutocompletable) it.next()).getEmoji());
                }
                mutableList.add(new EmojiUpsellPlaceholder(size, arrayList2, reducedMotionEnabled && ((EmojiAutocompletable) _Collections.first((List) arrayList)).getAnimationsEnabled()));
                mutableList.removeAll(arrayList);
            }
        }
        return (isAutocompletable || (mutableList.isEmpty() ^ true) || (stickers.isEmpty() ^ true)) ? new AutocompleteViewModel4.Autocomplete(false, false, isAutocompletable, mutableList, stickers, token, 2, null) : AutocompleteViewModel4.Hidden.INSTANCE;
    }

    public static /* synthetic */ AutocompleteViewModel4 getAutocompleteViewState$default(AutocompleteViewModel autocompleteViewModel, String str, List list, List list2, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return autocompleteViewModel.getAutocompleteViewState(str, list, list2, z2);
    }

    private final User getChannelBot(Channel channel) {
        User userA = ChannelUtils.a(channel);
        if (userA == null) {
            return null;
        }
        if (!userA.getIsBot()) {
            userA = null;
        }
        return userA;
    }

    private final AutocompleteViewModel6 getSelectedCommandViewState(AutocompleteInputSelectionModel model) {
        InputSelectionModel inputSelectionModel = model.getInputSelectionModel();
        if (inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel) {
            ApplicationCommand selectedCommand = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandContext().getSelectedCommand();
            Application selectedApplication = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandContext().getSelectedApplication();
            return (selectedCommand == null || selectedApplication == null) ? AutocompleteViewModel6.Hidden.INSTANCE : new AutocompleteViewModel6.SelectedCommand(selectedCommand, ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getSelectedCommandOption(), model.getShowErrorsForOptions(), ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandOptionValidity(), selectedApplication);
        }
        if (inputSelectionModel instanceof InputSelectionModel.MessageInputSelectionModel) {
            return AutocompleteViewModel6.Hidden.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @MainThread
    private final void handleAutocompleteInputSelectionModel(AutocompleteInputSelectionModel model) {
        AutocompleteViewModel4 autocompleteViewState;
        CommandAutocompleteState commandAutocompleteState;
        StoreState storeState;
        WidgetChatInputDiscoveryCommandsModel browserCommands;
        WidgetChatInputDiscoveryCommandsModel browserCommands2;
        MentionToken autocompleteToken = model.getAutocompleteToken();
        AutocompleteViewModel4 autocomplete = null;
        jumpedApplicationId = null;
        Long jumpedApplicationId = null;
        autocomplete = null;
        autocomplete = null;
        autocomplete = null;
        if (Intrinsics3.areEqual(model.getInputSelectionModel().getInputModel().getInput().toString(), COMMAND_DISCOVER_TOKEN)) {
            StoreState storeState2 = this.storeState;
            if (storeState2 != null && (browserCommands2 = storeState2.getBrowserCommands()) != null) {
                jumpedApplicationId = browserCommands2.getJumpedApplicationId();
            }
            if (jumpedApplicationId != null && ((storeState = this.storeState) == null || (browserCommands = storeState.getBrowserCommands()) == null || browserCommands.getJumpedSequenceId() != this.lastJumpedSequenceId)) {
                Integer num = this.inputState.getApplicationsPosition().get(jumpedApplicationId);
                this.events.onNext(new AutocompleteViewModel5.ScrollAutocompletablesToApplication(jumpedApplicationId.longValue(), num != null ? num.intValue() : 3));
            }
            autocompleteViewState = getApplicationCommandsBrowserViewState();
        } else if (autocompleteToken != null) {
            boolean z2 = false;
            if (model.getInputSelectionModel() instanceof InputSelectionModel.CommandInputSelectionModel) {
                ApplicationCommandOption selectedCommandOption = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getSelectedCommandOption();
                Map<String, CommandAutocompleteState> map = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getCommandOptionAutocompleteItems().get(selectedCommandOption != null ? selectedCommandOption.getName() : null);
                if (map != null) {
                    CommandOptionValue commandOptionValue = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandOptionValues().get(selectedCommandOption);
                    commandAutocompleteState = map.get(String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null));
                } else {
                    commandAutocompleteState = null;
                }
                if (selectedCommandOption != null && selectedCommandOption.getAutocomplete()) {
                    z2 = true;
                }
                Boolean bool = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandOptionValidity().get(selectedCommandOption);
                if (selectedCommandOption != null && selectedCommandOption.getAutocomplete() && !(commandAutocompleteState instanceof CommandAutocompleteState.Choices) && (!Intrinsics3.areEqual(bool, Boolean.TRUE))) {
                    autocomplete = new AutocompleteViewModel4.Autocomplete(true, commandAutocompleteState instanceof CommandAutocompleteState.Failed, true, Collections2.emptyList(), Collections2.emptyList(), autocompleteToken.getToken());
                } else if (selectedCommandOption != null && selectedCommandOption.getAutocomplete() && Intrinsics3.areEqual(bool, Boolean.TRUE)) {
                    autocomplete = AutocompleteViewModel4.Hidden.INSTANCE;
                }
            }
            if (autocomplete == null) {
                List<Autocompletable> listFilterMentionsFromToken = AutocompleteModelUtils.INSTANCE.filterMentionsFromToken(autocompleteToken, model.getInputSelectionModel(), model.getFilteredAutocompletables());
                List<Sticker> stickerMatches = model.getStickerMatches();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(stickerMatches, 10));
                Iterator<T> it = stickerMatches.iterator();
                while (it.hasNext()) {
                    arrayList.add(new WidgetChatInputAutocompleteStickerAdapter2((Sticker) it.next(), null, 0, 6, null));
                }
                autocompleteViewState = getAutocompleteViewState(autocompleteToken.getToken(), listFilterMentionsFromToken, arrayList, z2);
            } else {
                autocompleteViewState = autocomplete;
            }
        } else {
            autocompleteViewState = AutocompleteViewModel4.Hidden.INSTANCE;
        }
        AutocompleteViewModel6 selectedCommandViewState = getSelectedCommandViewState(model);
        ApplicationCommand applicationCommandNewSelectedCommand = newSelectedCommand(model, this.lastAutocompleteInputSelectionModel);
        if (applicationCommandNewSelectedCommand != null) {
            onNewCommandSelected(applicationCommandNewSelectedCommand);
        } else if (commandCleared(model, this.lastAutocompleteInputSelectionModel)) {
            onCommandCleared();
        }
        if (newSelectedCommandOption(model, this.lastAutocompleteInputSelectionModel) != null) {
            this.storeApplicationCommands.clearAutocompleteResults();
        }
        ApplicationCommandOption applicationCommandOptionHasAddedAttachmentOption = hasAddedAttachmentOption(model, this.lastAutocompleteInputSelectionModel);
        if (applicationCommandOptionHasAddedAttachmentOption != null) {
            selectAttachmentOption(applicationCommandOptionHasAddedAttachmentOption);
        }
        this.lastAutocompleteInputSelectionModel = model;
        updateViewState(new AutocompleteViewModel7(autocompleteViewState, selectedCommandViewState));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00f6  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleInputSelectionModel(InputSelectionModel newModel) throws IOException {
        Set<ApplicationCommandOption> setEmptySet;
        MentionToken commandAutocompleteToken;
        if (newModel.getSelection().getLast() > newModel.getInputModel().getInput().length()) {
            return;
        }
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        InputEditTextAction replacePillSpans = new InputEditTextAction.ReplacePillSpans(newModel.getInputModel().getInput(), null, 2, null);
        boolean z2 = newModel instanceof InputSelectionModel.CommandInputSelectionModel;
        if (z2) {
            AutocompleteCommandUtils autocompleteCommandUtils = AutocompleteCommandUtils.INSTANCE;
            InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) newModel;
            ApplicationCommand selectedCommand = commandInputSelectionModel.getInputModel().getInputCommandContext().getSelectedCommand();
            ApplicationCommandOption selectedCommandOption = commandInputSelectionModel.getSelectedCommandOption();
            if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
                inputSelectionModel = null;
            }
            InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
            setEmptySet = _Collections.toMutableSet(autocompleteCommandUtils.getErrorsToShowForCommandParameters(selectedCommand, selectedCommandOption, commandInputSelectionModel2 != null ? commandInputSelectionModel2.getSelectedCommandOption() : null, commandInputSelectionModel.getInputModel().getInputCommandOptionValidity(), commandInputSelectionModel.getInputModel().getInputCommandOptionValues()));
            ApplicationCommandOption showErrorForOption = this.inputState.getShowErrorForOption();
            if (showErrorForOption != null) {
                if (Intrinsics3.areEqual(commandInputSelectionModel.getInputModel().getInputCommandOptionValidity().get(showErrorForOption), Boolean.TRUE) || (!Intrinsics3.areEqual(commandInputSelectionModel.getSelectedCommandOption(), showErrorForOption))) {
                    this.inputState = InputState.copy$default(this.inputState, null, null, null, null, null, 23, null);
                } else {
                    setEmptySet.add(showErrorForOption);
                }
            }
            replacePillSpans = applyCommandOptionSpans(commandInputSelectionModel.getInputModel(), commandInputSelectionModel.getSelectedCommandOption(), setEmptySet);
        } else {
            setEmptySet = Sets5.emptySet();
        }
        Set<ApplicationCommandOption> set = setEmptySet;
        this.editTextAction.onNext(replacePillSpans);
        if (z2) {
            InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel3 = (InputSelectionModel.CommandInputSelectionModel) newModel;
            commandAutocompleteToken = commandInputSelectionModel3.getSelectedCommandOption() != null ? AutocompleteModelUtils.INSTANCE.getCommandAutocompleteToken(commandInputSelectionModel3.getInputModel().getInput(), newModel.getSelection(), commandInputSelectionModel3.getSelectedCommandOption(), InputSelectionModel2.hasSelectedFreeformInput(newModel), commandInputSelectionModel3.getInputModel().getInputCommandOptionsRanges(), commandInputSelectionModel3.getInputModel().getInputCommandOptionValues()) : AutocompleteModelUtils.INSTANCE.getMessageAutocompleteToken(newModel.getInputModel().getInput(), newModel.getSelection());
        }
        MentionToken mentionToken = commandAutocompleteToken;
        AutocompleteModelUtils autocompleteModelUtils = AutocompleteModelUtils.INSTANCE;
        List<Sticker> stickerMatches = autocompleteModelUtils.getStickerMatches(mentionToken);
        Map<LeadingIdentifier, List<Autocompletable>> mapFilterAutocompletablesForInputContext = autocompleteModelUtils.filterAutocompletablesForInputContext(newModel);
        this.lastChatInputModel = newModel;
        this.autocompleteInputSelectionModelSubject.onNext(new AutocompleteInputSelectionModel(mentionToken, mapFilterAutocompletablesForInputContext, newModel, set, stickerMatches));
    }

    @MainThread
    private final void handleNewChannel(CharSequence currentInput, Channel oldChannel, Channel newChannel) {
        User channelBot = getChannelBot(newChannel);
        Long lValueOf = newChannel.getGuildId() == 0 ? null : Long.valueOf(newChannel.getGuildId());
        boolean z2 = true;
        if (!(!Intrinsics3.areEqual(oldChannel != null ? Long.valueOf(oldChannel.getGuildId()) : null, lValueOf))) {
            if ((oldChannel != null ? Long.valueOf(oldChannel.getGuildId()) : null) != null || lValueOf != null) {
                z2 = false;
            }
        }
        if (channelBot != null) {
            this.storeApplicationCommands.handleDmUserApplication(channelBot);
        } else if (z2) {
            this.storeApplicationCommands.requestFrecencyCommands(lValueOf != null ? lValueOf.longValue() : 0L);
            this.storeApplicationCommands.requestApplications(lValueOf);
        }
        String commandPrefix = currentInput != null ? AutocompleteCommandUtils.INSTANCE.getCommandPrefix(currentInput) : null;
        if (commandPrefix != null) {
            queryCommandsFromCommandPrefixToken(commandPrefix, newChannel);
        }
    }

    private final InputSelectionModel handleSelectionWithInputModel(Ranges2 selection, MentionInputModel inputModel) {
        if (inputModel instanceof MentionInputModel.VerifiedCommandInputModel) {
            MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel = (MentionInputModel.VerifiedCommandInputModel) inputModel;
            return new InputSelectionModel.CommandInputSelectionModel(verifiedCommandInputModel, selection, AutocompleteCommandUtils.INSTANCE.getSelectedCommandOption(selection.getFirst(), verifiedCommandInputModel.getInputCommandOptionsRanges()));
        }
        if (inputModel instanceof MentionInputModel.VerifiedMessageInputModel) {
            return new InputSelectionModel.MessageInputSelectionModel(inputModel, selection);
        }
        throw new NoWhenBranchMatchedException();
    }

    @MainThread
    private final void handleStoreState(StoreState newState) {
        Channel channel;
        StoreState storeState = this.storeState;
        if (storeState == null || (channel = storeState.getChannel()) == null || channel.getId() != newState.getChannel().getId()) {
            CharSequence currentInput = this.inputState.getCurrentInput();
            StoreState storeState2 = this.storeState;
            handleNewChannel(currentInput, storeState2 != null ? storeState2.getChannel() : null, newState.getChannel());
        }
        if (!Intrinsics3.areEqual(this.storeState != null ? r0.getFrecencyCommandIds() : null, newState.getFrecencyCommandIds())) {
            this.storeApplicationCommands.requestFrecencyCommands(newState.getChannel().getGuildId());
        }
        if ((!Intrinsics3.areEqual(this.storeState != null ? r0.getBrowserCommands() : null, newState.getBrowserCommands())) && newState.getBrowserCommands() != null) {
            this.inputState = InputState.copy$default(this.inputState, null, null, getCommandBrowserCommandPositions(newState.getBrowserCommands()), null, null, 27, null);
        }
        this.storeState = newState;
        onDataUpdated(this.inputState, newState);
    }

    private final ApplicationCommandOption hasAddedAttachmentOption(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        Set setEmptySet;
        Set setEmptySet2;
        MentionInputModel.VerifiedCommandInputModel inputModel;
        Map<ApplicationCommandOption, OptionRange> inputCommandOptionsRanges;
        MentionInputModel.VerifiedCommandInputModel inputModel2;
        Map<ApplicationCommandOption, OptionRange> inputCommandOptionsRanges2;
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        if (commandInputSelectionModel == null || (inputModel2 = commandInputSelectionModel.getInputModel()) == null || (inputCommandOptionsRanges2 = inputModel2.getInputCommandOptionsRanges()) == null) {
            setEmptySet = null;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<ApplicationCommandOption, OptionRange> entry : inputCommandOptionsRanges2.entrySet()) {
                if (entry.getKey().getType() == ApplicationCommandType.ATTACHMENT) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            setEmptySet = linkedHashMap.keySet();
        }
        if (setEmptySet == null) {
            setEmptySet = Sets5.emptySet();
        }
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel2;
        if (commandInputSelectionModel2 == null || (inputModel = commandInputSelectionModel2.getInputModel()) == null || (inputCommandOptionsRanges = inputModel.getInputCommandOptionsRanges()) == null) {
            setEmptySet2 = null;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<ApplicationCommandOption, OptionRange> entry2 : inputCommandOptionsRanges.entrySet()) {
                if (entry2.getKey().getType() == ApplicationCommandType.ATTACHMENT) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            setEmptySet2 = linkedHashMap2.keySet();
        }
        if (setEmptySet2 == null) {
            setEmptySet2 = Sets5.emptySet();
        }
        Set setMinus = _Sets.minus(setEmptySet, (Iterable) setEmptySet2);
        if (setMinus.size() == 1) {
            return (ApplicationCommandOption) _Collections.first(setMinus);
        }
        return null;
    }

    private final ApplicationCommand newSelectedCommand(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        MentionInputModel.VerifiedCommandInputModel inputModel;
        InputCommandContext inputCommandContext;
        MentionInputModel.VerifiedCommandInputModel inputModel2;
        InputCommandContext inputCommandContext2;
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        ApplicationCommand selectedCommand = (commandInputSelectionModel == null || (inputModel2 = commandInputSelectionModel.getInputModel()) == null || (inputCommandContext2 = inputModel2.getInputCommandContext()) == null) ? null : inputCommandContext2.getSelectedCommand();
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel2;
        if (!Intrinsics3.areEqual(selectedCommand != null ? selectedCommand.getId() : null, ((commandInputSelectionModel2 == null || (inputModel = commandInputSelectionModel2.getInputModel()) == null || (inputCommandContext = inputModel.getInputCommandContext()) == null) ? null : inputCommandContext.getSelectedCommand()) != null ? r4.getId() : null)) {
            return selectedCommand;
        }
        return null;
    }

    private final ApplicationCommandOption newSelectedCommandOption(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        ApplicationCommandOption selectedCommandOption = commandInputSelectionModel != null ? commandInputSelectionModel.getSelectedCommandOption() : null;
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel2;
        if (!Intrinsics3.areEqual(selectedCommandOption != null ? selectedCommandOption.getName() : null, (commandInputSelectionModel2 != null ? commandInputSelectionModel2.getSelectedCommandOption() : null) != null ? r4.getName() : null)) {
            return selectedCommandOption;
        }
        return null;
    }

    private final void onCommandCleared() {
        this.commandAttachments.clear();
        this.flexInputViewModel.onAttachmentsUpdated(Collections2.emptyList());
    }

    private final void onNewCommandSelected(ApplicationCommand newSelectedCommand) {
        this.commandAttachments.clear();
        this.flexInputViewModel.onAttachmentsUpdated(Collections2.emptyList());
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreAnalytics analytics = companion.getAnalytics();
        long id2 = companion.getChannelsSelected().getId();
        long applicationId = newSelectedCommand.getApplicationId();
        Long longOrNull = StringNumberConversions.toLongOrNull(newSelectedCommand.getId());
        analytics.trackApplicationCommandSelected(id2, applicationId, longOrNull != null ? longOrNull.longValue() : 0L);
    }

    @MainThread
    private final InputEditTextAction onPreAutocompleteCompute(CharSequence input) {
        return replacementSpanCommandParamDeletion(input);
    }

    @MainThread
    private final void queryCommandsFromCommandPrefixToken(String commandPrefix, Channel channel) {
        User channelBot = getChannelBot(channel);
        Long lValueOf = channelBot != null ? Long.valueOf(channelBot.getId()) : null;
        long guildId = channel.getGuildId();
        if (commandPrefix.length() <= 1 && lValueOf == null) {
            this.storeApplicationCommands.clearQueryCommands();
        }
        if (commandPrefix.length() == 1) {
            this.storeApplicationCommands.requestInitialApplicationCommands(Long.valueOf(guildId), lValueOf, true);
            return;
        }
        if (commandPrefix.length() <= 1 || lValueOf != null) {
            return;
        }
        StoreApplicationCommands storeApplicationCommands = this.storeApplicationCommands;
        Long lValueOf2 = Long.valueOf(guildId);
        String strSubstring = commandPrefix.substring(1);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        storeApplicationCommands.requestApplicationCommandsQuery(lValueOf2, strSubstring);
    }

    private final void removeAttachment(ApplicationCommandOption commandOption) {
        MentionInputModel inputModel;
        CharSequence input;
        InputSelectionModel inputSelectionModel;
        ApplicationCommand selectedCommand;
        OptionRange optionRange;
        Attachment<?> attachment = this.commandAttachments.get(commandOption);
        if (attachment != null) {
            this.commandAttachments.remove(commandOption);
            this.flexInputViewModel.removeAttachment(attachment);
            InputSelectionModel inputSelectionModel2 = this.lastChatInputModel;
            if (inputSelectionModel2 == null || (inputModel = inputSelectionModel2.getInputModel()) == null || (input = inputModel.getInput()) == null || (inputSelectionModel = this.lastChatInputModel) == null || (selectedCommand = InputSelectionModel2.getSelectedCommand(inputSelectionModel)) == null || (optionRange = AutocompleteCommandUtils.INSTANCE.findOptionRanges(input, selectedCommand, this.commandAttachments).get(commandOption)) == null) {
                return;
            }
            this.editTextAction.onNext(new InputEditTextAction.RemoveText(input, new Ranges2(optionRange.getParam().getFirst(), optionRange.getValue().getLast()), optionRange.getParam().getFirst()));
        }
    }

    @MainThread
    private final InputEditTextAction replacementSpanCommandParamDeletion(CharSequence input) {
        String string = input.toString();
        SpannedString spannedStringValueOf = SpannedString.valueOf(input);
        Intrinsics3.checkNotNullExpressionValue(spannedStringValueOf, "valueOf(this)");
        Object[] spans = spannedStringValueOf.getSpans(0, input.length(), SimpleRoundedBackgroundSpan.class);
        Intrinsics3.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        for (SimpleRoundedBackgroundSpan simpleRoundedBackgroundSpan : (SimpleRoundedBackgroundSpan[]) spans) {
            Ranges2 ranges2 = new Ranges2(spannedStringValueOf.getSpanStart(simpleRoundedBackgroundSpan), spannedStringValueOf.getSpanEnd(simpleRoundedBackgroundSpan));
            Character orNull = _Strings.getOrNull(string, ranges2.getLast());
            boolean z2 = orNull != null && orNull.charValue() == ':';
            int first = ranges2.getFirst();
            int last = ranges2.getLast();
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = string.substring(first, last);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (simpleRoundedBackgroundSpan instanceof ApplicationCommandSpan) {
                ApplicationCommandSpan applicationCommandSpan = (ApplicationCommandSpan) simpleRoundedBackgroundSpan;
                if (applicationCommandSpan.getCommandOption().getType() == ApplicationCommandType.ATTACHMENT) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(applicationCommandSpan.getCommandOption().getName());
                    sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                    Attachment<?> attachment = this.commandAttachments.get(applicationCommandSpan.getCommandOption());
                    sb.append(attachment != null ? attachment.getDisplayName() : null);
                    if (!Strings4.contains$default((CharSequence) strSubstring, (CharSequence) sb.toString(), false, 2, (Object) null)) {
                        removeAttachment(applicationCommandSpan.getCommandOption());
                        return new InputEditTextAction.RemoveText(string, new Ranges2(ranges2.getFirst(), ranges2.getLast()), Math.min(ranges2.getFirst() + 1, string.length() - (ranges2.getLast() - ranges2.getFirst())));
                    }
                }
            }
            if (!Strings4.contains$default((CharSequence) strSubstring, MentionUtils.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null) && !z2) {
                return new InputEditTextAction.RemoveText(string, new Ranges2(ranges2.getFirst(), ranges2.getLast()), ranges2.getFirst());
            }
        }
        return new InputEditTextAction.None(input);
    }

    private final void selectAttachmentOption(ApplicationCommandOption applicationCommandsOption) {
        Attachment<?> attachment = this.commandAttachments.get(applicationCommandsOption);
        if (attachment != null) {
            this.selectedOptionForAttachment = applicationCommandsOption;
            this.events.onNext(new AutocompleteViewModel5.PreviewAttachment(attachment));
        } else {
            this.selectedOptionForAttachment = applicationCommandsOption;
            this.events.onNext(new AutocompleteViewModel5.PickAttachment(applicationCommandsOption));
        }
    }

    @MainThread
    private final void selectFirstInvalidCommandOption() {
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        MentionInputModel inputModel = inputSelectionModel != null ? inputSelectionModel.getInputModel() : null;
        if (inputModel instanceof MentionInputModel.VerifiedCommandInputModel) {
            Map<ApplicationCommandOption, Boolean> inputCommandOptionValidity = ((MentionInputModel.VerifiedCommandInputModel) inputModel).getInputCommandOptionValidity();
            for (ApplicationCommandOption applicationCommandOption : inputCommandOptionValidity.keySet()) {
                if (Intrinsics3.areEqual(inputCommandOptionValidity.get(applicationCommandOption), Boolean.FALSE)) {
                    this.inputState = InputState.copy$default(this.inputState, null, null, null, applicationCommandOption, null, 23, null);
                    selectCommandOption(applicationCommandOption);
                    return;
                }
            }
        }
    }

    public final void checkEmojiAutocompleteUpsellViewed(List<? extends Autocompletable> visibleItems) {
        Autocompletable autocompletablePrevious;
        Intrinsics3.checkNotNullParameter(visibleItems, "visibleItems");
        if (this.emojiAutocompleteUpsellEnabled && this.logEmojiAutocompleteUpsellViewed) {
            ListIterator<? extends Autocompletable> listIterator = visibleItems.listIterator(visibleItems.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    autocompletablePrevious = null;
                    break;
                } else {
                    autocompletablePrevious = listIterator.previous();
                    if (autocompletablePrevious instanceof EmojiUpsellPlaceholder) {
                        break;
                    }
                }
            }
            if (autocompletablePrevious != null) {
                this.logEmojiAutocompleteUpsellViewed = false;
                StoreStream.INSTANCE.getAnalytics().emojiAutocompleteUpsellInlineViewed();
            }
        }
    }

    @MainThread
    public final AutocompleteViewModel4 getApplicationCommandsBrowserViewState() {
        Experiment userExperiment;
        StoreState storeState = this.storeState;
        if (storeState == null || storeState.getBrowserCommands() == null) {
            return AutocompleteViewModel4.Hidden.INSTANCE;
        }
        boolean z2 = (storeState.getFrecencyCommands().isEmpty() ^ true) && (userExperiment = this.storeExperiments.getUserExperiment("2021-09_android_app_commands_frecency", true)) != null && userExperiment.getBucket() == 1;
        List<ApplicationCommand> frecencyCommands = z2 ? storeState.getFrecencyCommands() : Collections2.emptyList();
        List<Application> applications = storeState.getApplications();
        ArrayList arrayList = new ArrayList();
        for (Object obj : applications) {
            Application application = (Application) obj;
            if (application.getCommandCount() > 0 || (z2 && application.getId() == -2 && (storeState.getFrecencyCommands().isEmpty() ^ true))) {
                arrayList.add(obj);
            }
        }
        return new AutocompleteViewModel4.CommandBrowser(frecencyCommands, arrayList, storeState.getBrowserCommands());
    }

    public final ApplicationCommandData getApplicationSendData(ApplicationCommandOption focusedOption) {
        AutocompleteModelUtils autocompleteModelUtils = AutocompleteModelUtils.INSTANCE;
        AutocompleteInputSelectionModel autocompleteInputSelectionModel = this.lastAutocompleteInputSelectionModel;
        StoreState storeState = this.storeState;
        List<Application> applications = storeState != null ? storeState.getApplications() : null;
        if (applications == null) {
            applications = Collections2.emptyList();
        }
        List<Application> list = applications;
        StoreState storeState2 = this.storeState;
        List<ApplicationCommand> queriedCommands = storeState2 != null ? storeState2.getQueriedCommands() : null;
        return autocompleteModelUtils.getApplicationSendData(autocompleteInputSelectionModel, focusedOption, list, queriedCommands != null ? queriedCommands : Collections2.emptyList(), this.commandAttachments);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Map<ApplicationCommandOption, Attachment<?>> getCommandAttachments() {
        return Util7.A(this.commandAttachments);
    }

    @MainThread
    public final Map<Long, Integer> getCommandBrowserCommandPositions(WidgetChatInputDiscoveryCommandsModel discoveryCommands) {
        Intrinsics3.checkNotNullParameter(discoveryCommands, "discoveryCommands");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = 0;
        for (Tuples2<Application, List<Autocompletable>> tuples2 : discoveryCommands.getCommandsByApplication()) {
            Application applicationComponent1 = tuples2.component1();
            List<Autocompletable> listComponent2 = tuples2.component2();
            Iterator<Autocompletable> it = listComponent2.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (!(it.next() instanceof ApplicationCommandLoadingPlaceholder)) {
                    break;
                }
                i++;
            }
            linkedHashMap.put(Long.valueOf(applicationComponent1.getId()), Integer.valueOf(_Ranges.coerceAtLeast(i, 0) + size));
            size += listComponent2.size();
        }
        return linkedHashMap;
    }

    public final int getCommandOptionErrorColor() {
        return this.commandOptionErrorColor;
    }

    public final int getDefaultCommandOptionBackgroundColor() {
        return this.defaultCommandOptionBackgroundColor;
    }

    public final int getDefaultMentionColor() {
        return this.defaultMentionColor;
    }

    public final boolean getEmojiAutocompleteUpsellEnabled() {
        return this.emojiAutocompleteUpsellEnabled;
    }

    public final AppFlexInputViewModel getFlexInputViewModel() {
        return this.flexInputViewModel;
    }

    public final InputState getInputState() {
        return this.inputState;
    }

    public final int getLastJumpedSequenceId() {
        return this.lastJumpedSequenceId;
    }

    public final StoreApplicationCommands getStoreApplicationCommands() {
        return this.storeApplicationCommands;
    }

    public final StoreState getStoreState() {
        return this.storeState;
    }

    public final Observable<InputEditTextAction> observeEditTextActions() {
        BehaviorSubject<InputEditTextAction> behaviorSubject = this.editTextAction;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "editTextAction");
        return behaviorSubject;
    }

    public final Observable<AutocompleteViewModel5> observeEvents() {
        BehaviorSubject<AutocompleteViewModel5> behaviorSubject = this.events;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "events");
        return behaviorSubject;
    }

    public final void onApplicationCommandSendError() {
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        Object obj = null;
        MentionInputModel inputModel = inputSelectionModel != null ? inputSelectionModel.getInputModel() : null;
        if (inputModel instanceof MentionInputModel.VerifiedCommandInputModel) {
            MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel = (MentionInputModel.VerifiedCommandInputModel) inputModel;
            ApplicationCommand selectedCommand = verifiedCommandInputModel.getInputCommandContext().getSelectedCommand();
            if (selectedCommand != null) {
                Map<ApplicationCommandOption, Boolean> inputCommandOptionValidity = verifiedCommandInputModel.getInputCommandOptionValidity();
                Iterator<T> it = selectedCommand.getOptions().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics3.areEqual(inputCommandOptionValidity.get((ApplicationCommandOption) next), Boolean.FALSE)) {
                        obj = next;
                        break;
                    }
                }
                ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) obj;
                if (applicationCommandOption != null) {
                    long applicationId = selectedCommand.getApplicationId();
                    Long longOrNull = selectedCommand instanceof ApplicationCommand3 ? StringNumberConversions.toLongOrNull(((ApplicationCommand3) selectedCommand).getRootCommand().getId()) : StringNumberConversions.toLongOrNull(selectedCommand.getId());
                    if (longOrNull != null) {
                        long jLongValue = longOrNull.longValue();
                        selectFirstInvalidCommandOption();
                        StoreStream.INSTANCE.getAnalytics().trackApplicationCommandValidationFailure(applicationId, jLongValue, applicationCommandOption.getType().toString(), applicationCommandOption.getRequired());
                    }
                }
            }
        }
    }

    public final void onAttachmentRemoved(Attachment<?> attachment) {
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        ApplicationCommandOption applicationCommandOption = this.selectedOptionForAttachment;
        if (applicationCommandOption != null) {
            removeAttachment(applicationCommandOption);
        }
    }

    public final void onAutocompleteItemsUpdated() {
        this.logEmojiAutocompleteUpsellViewed = true;
    }

    public final void onCommandsBrowserScroll(int firstVisibleItemPosition, int lastVisibleItemPosition, int totalItems) {
        WidgetChatInputDiscoveryCommandsModel browserCommands;
        WidgetChatInputDiscoveryCommandsModel browserCommands2;
        StoreState storeState = this.storeState;
        if (storeState == null || (browserCommands2 = storeState.getBrowserCommands()) == null || !browserCommands2.getHasMoreBefore() || firstVisibleItemPosition > 3) {
            StoreState storeState2 = this.storeState;
            if (storeState2 != null && (browserCommands = storeState2.getBrowserCommands()) != null && browserCommands.getHasMoreAfter() && lastVisibleItemPosition >= (totalItems - 3) - 6) {
                StoreStream.INSTANCE.getApplicationCommands().requestLoadMoreDown();
            }
        } else {
            StoreStream.INSTANCE.getApplicationCommands().requestLoadMoreUp();
        }
        StoreStream.INSTANCE.getAnalytics().trackApplicationCommandBrowserScrolled();
    }

    @MainThread
    public final InputEditTextAction onDataUpdated(InputState inputState, StoreState storeState) {
        MentionInputModel verifiedMessageInputModel;
        Intrinsics3.checkNotNullParameter(inputState, "inputState");
        if (storeState == null) {
            return new InputEditTextAction.None(inputState.getCurrentInput());
        }
        AutocompleteApplicationCommands autocompleteApplicationCommands = new AutocompleteApplicationCommands(storeState.getApplications(), storeState.getQueriedCommands(), storeState.getBrowserCommands());
        AutocompleteInputModel autocompleteInputModel = new AutocompleteInputModel(inputState.getCurrentInput(), storeState.getAutocompletables(), autocompleteApplicationCommands);
        AutocompleteCommandUtils autocompleteCommandUtils = AutocompleteCommandUtils.INSTANCE;
        InputCommandContext inputCommandContext = autocompleteCommandUtils.getInputCommandContext(autocompleteInputModel.getInput(), storeState.getUserId(), storeState.getUserRoles(), autocompleteApplicationCommands, inputState.getSelectedCommand());
        ChatInputMentionsMap chatInputMentionsMapMapInputToMentions = AutocompleteModelUtils.INSTANCE.mapInputToMentions(autocompleteInputModel.getInput().toString(), storeState.getAutocompletables(), inputState.getInputAutocompleteMap(), inputCommandContext.getIsCommand());
        if (inputCommandContext.getSelectedCommand() != null) {
            ApplicationCommand selectedCommand = inputCommandContext.getSelectedCommand();
            Map<ApplicationCommandOption, OptionRange> mapFindOptionRanges = autocompleteCommandUtils.findOptionRanges(autocompleteInputModel.getInput(), selectedCommand, this.commandAttachments);
            Map<ApplicationCommandOption, CommandOptionValue> commandOptions = autocompleteCommandUtils.parseCommandOptions(autocompleteInputModel.getInput(), selectedCommand, chatInputMentionsMapMapInputToMentions, this.commandAttachments);
            verifiedMessageInputModel = new MentionInputModel.VerifiedCommandInputModel(autocompleteInputModel.getInput(), autocompleteInputModel.getAutocompletables(), chatInputMentionsMapMapInputToMentions.getMentions(), null, null, null, storeState.getCommandOptionAutocompleteItems(), inputCommandContext, autocompleteInputModel.getApplicationCommands(), commandOptions, mapFindOptionRanges, autocompleteCommandUtils.getInputValidity(selectedCommand, commandOptions, this.commandAttachments, chatInputMentionsMapMapInputToMentions), 56, null);
        } else {
            verifiedMessageInputModel = new MentionInputModel.VerifiedMessageInputModel(autocompleteInputModel.getInput(), autocompleteInputModel.getAutocompletables(), chatInputMentionsMapMapInputToMentions.getMentions());
        }
        if (verifiedMessageInputModel instanceof MentionInputModel.VerifiedCommandInputModel) {
            InputEditTextAction inputEditTextActionAppendTextForCommandForInput = autocompleteCommandUtils.appendTextForCommandForInput((MentionInputModel.VerifiedCommandInputModel) verifiedMessageInputModel);
            if (inputEditTextActionAppendTextForCommandForInput instanceof InputEditTextAction.InsertText) {
                return inputEditTextActionAppendTextForCommandForInput;
            }
        }
        InputEditTextAction clearSpans = ((inputState.getCurrentInput().length() == 0) || Intrinsics3.areEqual(inputState.getCurrentInput().toString(), COMMAND_DISCOVER_TOKEN)) ? new InputEditTextAction.ClearSpans(inputState.getCurrentInput()) : generateSpanUpdates(verifiedMessageInputModel);
        this.inputMentionModelSubject.onNext(verifiedMessageInputModel);
        this.inputState = InputState.copy$default(inputState, null, inputCommandContext.getSelectedCommand(), null, null, chatInputMentionsMapMapInputToMentions.getMentions(), 13, null);
        return clearSpans;
    }

    @MainThread
    public final InputEditTextAction onInputTextChanged(CharSequence input, int start, int before, int count) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(input, "input");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Ranges2, Autocompletable> entry : this.inputState.getInputAutocompleteMap().entrySet()) {
            if (input.length() < entry.getKey().getLast() || !entry.getValue().matchesText(input.subSequence(entry.getKey().getFirst(), entry.getKey().getLast()).toString())) {
                Ranges2 ranges2ShiftOrRemove = AutocompleteModelUtils.INSTANCE.shiftOrRemove(entry.getKey(), start, before, count);
                if (ranges2ShiftOrRemove != null) {
                    linkedHashMap.put(ranges2ShiftOrRemove, entry.getValue());
                }
            } else {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.inputState = InputState.copy$default(this.inputState, null, null, null, null, linkedHashMap, 15, null);
        InputEditTextAction inputEditTextActionOnPreAutocompleteCompute = onPreAutocompleteCompute(input);
        if (!(inputEditTextActionOnPreAutocompleteCompute instanceof InputEditTextAction.None)) {
            return inputEditTextActionOnPreAutocompleteCompute;
        }
        StoreState storeState = this.storeState;
        if (storeState != null && (channel = storeState.getChannel()) != null) {
            checkForCommandsToQuery(input, this.inputState.getCurrentInput(), channel);
        }
        InputState inputState = this.inputState;
        SpannableString spannableStringValueOf = SpannableString.valueOf(input.toString());
        Intrinsics3.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
        return onDataUpdated(InputState.copy$default(inputState, spannableStringValueOf, null, null, null, null, 30, null), this.storeState);
    }

    public final void onSelectionChanged(String input, int start, int finish) {
        Intrinsics3.checkNotNullParameter(input, "input");
        this.inputSelectionSubject.onNext(new SelectionState(input, new Ranges2(start, finish)));
    }

    public final MessageContent replaceAutocompletableDataWithServerValues(String content) {
        MentionInputModel inputModel;
        Map<Ranges2, Autocompletable> inputMentionsMap;
        Intrinsics3.checkNotNullParameter(content, "content");
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        if (inputSelectionModel == null || (inputModel = inputSelectionModel.getInputModel()) == null || (inputMentionsMap = inputModel.getInputMentionsMap()) == null) {
            return new MessageContent(content, Collections2.emptyList());
        }
        String strReplaceAutocompleteDataWithServerValues = AutocompleteExtensions.replaceAutocompleteDataWithServerValues(content, inputMentionsMap);
        List listFilterIsInstance = _CollectionsJvm.filterIsInstance(inputMentionsMap.values(), UserAutocompletable.class);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listFilterIsInstance, 10));
        Iterator it = listFilterIsInstance.iterator();
        while (it.hasNext()) {
            arrayList.add(((UserAutocompletable) it.next()).getUser());
        }
        int length = strReplaceAutocompleteDataWithServerValues.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics3.compare(strReplaceAutocompleteDataWithServerValues.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        return new MessageContent(strReplaceAutocompleteDataWithServerValues.subSequence(i, length + 1).toString(), arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.CharSequence] */
    @MainThread
    public final void selectAutocompleteItem(Autocompletable autocompletable) {
        MentionToken autocompleteToken;
        InputSelectionModel inputSelectionModel;
        MentionInputModel inputModel;
        ?? input;
        Ranges2 value;
        MentionInputModel inputModel2;
        CharSequence input2;
        Intrinsics3.checkNotNullParameter(autocompletable, "autocompletable");
        String str = "";
        if (autocompletable instanceof ApplicationCommandAutocompletable) {
            StringBuilder sb = new StringBuilder();
            sb.append(autocompletable.leadingIdentifier().getIdentifier());
            ApplicationCommandAutocompletable applicationCommandAutocompletable = (ApplicationCommandAutocompletable) autocompletable;
            sb.append(applicationCommandAutocompletable.getCommand().getName());
            sb.append(' ');
            String string = sb.toString();
            this.inputState = InputState.copy$default(this.inputState, null, applicationCommandAutocompletable.getCommand(), null, null, null, 29, null);
            BehaviorSubject<InputEditTextAction> behaviorSubject = this.editTextAction;
            InputSelectionModel inputSelectionModel2 = this.lastChatInputModel;
            behaviorSubject.onNext(new InputEditTextAction.ReplaceText((inputSelectionModel2 == null || (inputModel2 = inputSelectionModel2.getInputModel()) == null || (input2 = inputModel2.getInput()) == null) ? "" : input2, string, 0, 4, null));
            return;
        }
        InputSelectionModel inputSelectionModel3 = this.lastChatInputModel;
        if (!(inputSelectionModel3 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            if ((inputSelectionModel3 instanceof InputSelectionModel.MessageInputSelectionModel) || inputSelectionModel3 == null) {
                AutocompleteInputSelectionModel autocompleteInputSelectionModel = this.lastAutocompleteInputSelectionModel;
                if (autocompleteInputSelectionModel != null && (inputSelectionModel = autocompleteInputSelectionModel.getInputSelectionModel()) != null && (inputModel = inputSelectionModel.getInputModel()) != null && (input = inputModel.getInput()) != 0) {
                    str = input;
                }
                AutocompleteInputSelectionModel autocompleteInputSelectionModel2 = this.lastAutocompleteInputSelectionModel;
                autocompleteToken = autocompleteInputSelectionModel2 != null ? autocompleteInputSelectionModel2.getAutocompleteToken() : null;
                if (!autocompletable.getInputTextMatchers().isEmpty()) {
                    Ranges2 ranges2 = autocompleteToken != null ? new Ranges2(autocompleteToken.getStartIndex(), autocompleteToken.getToken().length() + autocompleteToken.getStartIndex()) : new Ranges2(str.length(), str.length());
                    String str2 = (String) _Collections.first((List) autocompletable.getInputTextMatchers());
                    String str3 = str2 + ' ';
                    InputState inputState = this.inputState;
                    Map mutableMap = Maps6.toMutableMap(inputState.getInputAutocompleteMap());
                    mutableMap.put(new Ranges2(ranges2.getFirst(), str2.length() + ranges2.getFirst()), autocompletable);
                    this.inputState = InputState.copy$default(inputState, null, null, null, null, mutableMap, 15, null);
                    this.editTextAction.onNext(new InputEditTextAction.InsertText(str, str3, ranges2, str3.length() + ranges2.getFirst()));
                    return;
                }
                return;
            }
            return;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel3;
        commandInputSelectionModel.getInputModel().getInputCommandContext().getSelectedCommand();
        ApplicationCommandOption selectedCommandOption = commandInputSelectionModel.getSelectedCommandOption();
        OptionRange optionRange = commandInputSelectionModel.getInputModel().getInputCommandOptionsRanges().get(selectedCommandOption);
        if (!(!autocompletable.getInputTextMatchers().isEmpty()) || selectedCommandOption == null || optionRange == null) {
            return;
        }
        String str4 = (String) _Collections.first((List) autocompletable.getInputTextMatchers());
        String str5 = str4 + ' ';
        Ranges2 selection = inputSelectionModel3.getSelection();
        if (InputSelectionModel2.hasSelectedFreeformInput(inputSelectionModel3)) {
            AutocompleteInputSelectionModel autocompleteInputSelectionModel3 = this.lastAutocompleteInputSelectionModel;
            autocompleteToken = autocompleteInputSelectionModel3 != null ? autocompleteInputSelectionModel3.getAutocompleteToken() : null;
            value = new Ranges2(autocompleteToken != null ? autocompleteToken.getStartIndex() : selection.getFirst() - 1, selection.getLast());
        } else {
            value = optionRange.getValue();
        }
        InputState inputState2 = this.inputState;
        Map mutableMap2 = Maps6.toMutableMap(inputState2.getInputAutocompleteMap());
        mutableMap2.put(new Ranges2(optionRange.getValue().getFirst(), str4.length() + optionRange.getValue().getFirst()), autocompletable);
        this.inputState = InputState.copy$default(inputState2, null, null, null, null, mutableMap2, 15, null);
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel3;
        this.editTextAction.onNext(new InputEditTextAction.InsertText(commandInputSelectionModel2.getInputModel().getInput(), str5, value, (str5.length() + commandInputSelectionModel2.getInputModel().getInput().length()) - (value.getLast() - value.getFirst())));
    }

    public final void selectCommandBrowserApplication(Application application) {
        Integer num;
        Intrinsics3.checkNotNullParameter(application, "application");
        StoreState storeState = this.storeState;
        if ((storeState != null ? storeState.getBrowserCommands() : null) == null || (num = this.inputState.getApplicationsPosition().get(Long.valueOf(application.getId()))) == null || !StoreStream.INSTANCE.getApplicationCommands().hasFetchedApplicationCommands(application.getId())) {
            StoreStream.INSTANCE.getApplicationCommands().requestDiscoverCommands(application.getId());
        } else {
            this.events.onNext(new AutocompleteViewModel5.ScrollAutocompletablesToApplication(application.getId(), num.intValue()));
        }
        StoreStream.INSTANCE.getAnalytics().trackApplicationCommandBrowserJump(application.getId());
    }

    @MainThread
    public final void selectCommandOption(ApplicationCommandOption applicationCommandsOption) {
        InputEditTextAction inputEditTextActionAppendParam$default;
        Attachment<?> attachment;
        Intrinsics3.checkNotNullParameter(applicationCommandsOption, "applicationCommandsOption");
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            boolean z2 = inputSelectionModel instanceof InputSelectionModel.MessageInputSelectionModel;
            return;
        }
        if (applicationCommandsOption.getType() == ApplicationCommandType.ATTACHMENT && (attachment = this.commandAttachments.get(applicationCommandsOption)) != null) {
            this.selectedOptionForAttachment = applicationCommandsOption;
            this.events.onNext(new AutocompleteViewModel5.PreviewAttachment(attachment));
            return;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        OptionRange optionRange = commandInputSelectionModel.getInputModel().getInputCommandOptionsRanges().get(applicationCommandsOption);
        Ranges2 value = optionRange != null ? optionRange.getValue() : null;
        if (value != null) {
            int iOrdinal = applicationCommandsOption.getType().ordinal();
            int i = 1;
            if (iOrdinal != 5 && iOrdinal != 6 && iOrdinal != 7 && iOrdinal != 8) {
                i = 0;
            }
            inputEditTextActionAppendParam$default = new InputEditTextAction.SelectText(commandInputSelectionModel.getInputModel().getInput(), new Ranges2(value.getFirst() + i, value.getLast() + (value.getLast() != commandInputSelectionModel.getInputModel().getInput().length() ? -1 : 0)));
        } else {
            inputEditTextActionAppendParam$default = AutocompleteCommandUtils.appendParam$default(AutocompleteCommandUtils.INSTANCE, commandInputSelectionModel.getInputModel().getInput(), applicationCommandsOption, null, 4, null);
        }
        this.editTextAction.onNext(inputEditTextActionAppendParam$default);
    }

    @MainThread
    public final void selectStickerItem(Sticker sticker) {
        String strReplaceAfterLast$default;
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getExpressionSuggestions().setExpressionSuggestionsEnabled(false);
        String string = this.inputState.getCurrentInput().toString();
        if (string.length() <= 1 || _Strings.last(string) != ':') {
            strReplaceAfterLast$default = Strings4.replaceAfterLast$default(string, MentionUtils.EMOJIS_AND_STICKERS_CHAR, "", null, 4, null);
        } else {
            String strSubstring = string.substring(0, Strings4.getLastIndex(string));
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            strReplaceAfterLast$default = Strings4.replaceAfterLast$default(strSubstring, MentionUtils.EMOJIS_AND_STICKERS_CHAR, "", null, 4, null);
        }
        String strSubstring2 = strReplaceAfterLast$default.substring(0, _Ranges.coerceAtLeast(strReplaceAfterLast$default.length() - 1, 0));
        Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        this.editTextAction.onNext(new InputEditTextAction.ReplaceText(string, strSubstring2, strSubstring2.length()));
        AutocompleteInputSelectionModel autocompleteInputSelectionModel = this.lastAutocompleteInputSelectionModel;
        if (autocompleteInputSelectionModel != null) {
            companion.getAnalytics().trackAutocompleteSelect(companion.getChannelsSelected().getId(), autocompleteInputSelectionModel.getAutocompleteType(), autocompleteInputSelectionModel.getEmojiNumCount(), autocompleteInputSelectionModel.getStickerNumCount(), AutocompleteUtils.STICKER, "sticker", Long.valueOf(sticker.getId()));
        }
        companion.getStickers().onStickerUsed(sticker);
    }

    public final void setAttachment(Attachment<?> attachment) {
        CharSequence input;
        MentionInputModel inputModel;
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        ApplicationCommandOption applicationCommandOption = this.selectedOptionForAttachment;
        if (applicationCommandOption != null) {
            this.commandAttachments.put(applicationCommandOption, attachment);
            InputSelectionModel inputSelectionModel = this.lastChatInputModel;
            if (inputSelectionModel == null || (inputModel = inputSelectionModel.getInputModel()) == null || (input = inputModel.getInput()) == null) {
                input = "";
            }
            InputSelectionModel inputSelectionModel2 = this.lastChatInputModel;
            OptionRange optionRange = AutocompleteCommandUtils.INSTANCE.findOptionRanges(input, inputSelectionModel2 != null ? InputSelectionModel2.getSelectedCommand(inputSelectionModel2) : null, this.commandAttachments).get(applicationCommandOption);
            Ranges2 ranges2 = optionRange != null ? new Ranges2(optionRange.getParam().getFirst(), optionRange.getValue().getLast()) : new Ranges2(input.length(), input.length());
            StringBuilder sbQ = outline.Q(' ');
            sbQ.append(applicationCommandOption.getName());
            sbQ.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
            sbQ.append(attachment.getDisplayName());
            sbQ.append(' ');
            String string = sbQ.toString();
            this.editTextAction.onNext(new InputEditTextAction.InsertText(input, string, ranges2, (string.length() + input.length()) - (ranges2.getLast() - ranges2.getFirst())));
        }
    }

    public final void setInputState(InputState inputState) {
        Intrinsics3.checkNotNullParameter(inputState, "<set-?>");
        this.inputState = inputState;
    }

    public final void setLastJumpedSequenceId(int i) {
        this.lastJumpedSequenceId = i;
    }

    public final void setStoreState(StoreState storeState) {
        this.storeState = storeState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutocompleteViewModel(Long l, AppFlexInputViewModel appFlexInputViewModel, StoreApplicationCommands storeApplicationCommands, StoreExperiments storeExperiments, @ColorInt int i, @ColorInt int i2, @ColorInt int i3, Observable<StoreState> observable) {
        super(new AutocompleteViewModel7(AutocompleteViewModel4.Hidden.INSTANCE, AutocompleteViewModel6.Hidden.INSTANCE));
        Intrinsics3.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        Intrinsics3.checkNotNullParameter(storeApplicationCommands, "storeApplicationCommands");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.channelId = l;
        this.flexInputViewModel = appFlexInputViewModel;
        this.storeApplicationCommands = storeApplicationCommands;
        this.storeExperiments = storeExperiments;
        this.defaultMentionColor = i;
        this.defaultCommandOptionBackgroundColor = i2;
        this.commandOptionErrorColor = i3;
        this.emojiAutocompleteUpsellEnabled = EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE.getINSTANCE().isEnabled();
        this.logEmojiAutocompleteUpsellViewed = true;
        BehaviorSubject<MentionInputModel> behaviorSubjectK0 = BehaviorSubject.k0();
        this.inputMentionModelSubject = behaviorSubjectK0;
        BehaviorSubject<AutocompleteInputSelectionModel> behaviorSubjectK02 = BehaviorSubject.k0();
        this.autocompleteInputSelectionModelSubject = behaviorSubjectK02;
        BehaviorSubject<SelectionState> behaviorSubjectK03 = BehaviorSubject.k0();
        this.inputSelectionSubject = behaviorSubjectK03;
        this.editTextAction = BehaviorSubject.k0();
        this.events = BehaviorSubject.k0();
        this.commandAttachments = new LinkedHashMap();
        this.inputState = new InputState(null, null, null, null, null, 31, null);
        Observable observableT = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).t(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableT, "storeObservable\n        …ore Error\", it)\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableT, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        Observable<SelectionState> observableR = behaviorSubjectK03.r();
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "inputMentionModelSubject");
        Observable observableJ = Observable.j(observableR, ObservableExtensionsKt.computationLatest(behaviorSubjectK0), new AnonymousClass3());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…inputModel)\n      }\n    }");
        ObservableExtensionsKt.AnonymousClass1 anonymousClass1 = ObservableExtensionsKt.AnonymousClass1.INSTANCE;
        Observable observableY = observableJ.y(anonymousClass1);
        ObservableExtensionsKt.AnonymousClass2 anonymousClass2 = ObservableExtensionsKt.AnonymousClass2.INSTANCE;
        Observable observableG = observableY.G(anonymousClass2);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableT2 = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null).t(AnonymousClass4.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableT2, "Observable.combineLatest…del Error\", it)\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableT2, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(this), 62, (Object) null);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK02, "autocompleteInputSelectionModelSubject");
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Observable observableT3 = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(behaviorSubjectK02, 100L, timeUnit)), this, null, 2, null).t(AnonymousClass6.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableT3, "autocompleteInputSelecti…del Error\", it)\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableT3, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass7(this), 62, (Object) null);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK02, "autocompleteInputSelectionModelSubject");
        Observable observableR2 = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(behaviorSubjectK02), this, null, 2, null).t(AnonymousClass8.INSTANCE).G(AnonymousClass9.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "autocompleteInputSelecti…  .distinctUntilChanged()");
        Observable observableG2 = observableR2.y(anonymousClass1).G(anonymousClass2);
        Intrinsics3.checkNotNullExpressionValue(observableG2, "filter { it != null }.map { it!! }");
        Observable observableP = observableG2.u(new AnonymousClass10()).p(500L, timeUnit);
        Intrinsics3.checkNotNullExpressionValue(observableP, "autocompleteInputSelecti…0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass11(), 62, (Object) null);
        Observable observableR3 = behaviorSubjectK02.G(AnonymousClass12.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR3, "autocompleteInputSelecti… }.distinctUntilChanged()");
        StoreGuilds.Actions.requestMembers(this, observableR3, true);
        this.lastJumpedSequenceId = -1;
    }
}
