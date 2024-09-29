package com.aries.smart.utils.flowbus


import java.util.HashMap

/**
 *
 * @Author: nicko
 * @CreateDate: 2022/12/14 14:46
 * @Description: flowbus发送的事件
 *
 */
sealed class Event {
    //显示房间浮窗
    data class ShowRoomFloating(var crId: String, var roomCover: String) : Event()

    //关闭悬浮窗
    object CloseRoomFloating : Event()

    //刷新悬浮窗封面
    data class RefreshRoomFloatingCoverEvent(var cover: String) : Event()

    //更换背景事件
    data class ChangeBackgroundEvent(var url: String) : Event()

    //刷新未读消息数量
    object RefreshUnReadMsgCount : Event()

    //application任务
    object InitApplicationTaskEvent : Event()

    //一键登录通知
    object InitOnKeyLoginEvent : Event()

    //刷新任务积分
    object RefreshPoints : Event()

    //刷新意见反馈
    object RefreshFeedBackType : Event()

    //使用积分
    object UseTaskRewardPointsEvent : Event()

    //打开盲盒
    object OpenBlindBoxEvent : Event()

    //系统通知
    object MsgSystemEvent : Event()

    //家族消息
    object MsgFamilyEvent : Event()

    //家族通过消息
    object MsgFamilyPassEvent : Event()


    //刷新积分
    object RefreshIntegralEvent : Event()


    //送礼轨迹动画
    data class PlayGiftFlyAnimationEvent(var index: Int, var url: String) : Event()

    //推流状态事件
    data class PublisherStateEvent(
        var streamID: String?
    ) : Event()

    //刷新金币
    object RefreshCoin : Event()

    //刷新树
    object RefreshTree : Event()


    //重置礼物选择状态
    data class ClearGiftChecked(var tabId: String) : Event()


    //潮播房主开播消息
    object AnchorStartLivestreamEvent : Event()

    //潮播房主下播消息
    object AnchorStopLivestreamEvent : Event()

    //歌曲列表播放
    data class ChangePlayMusicList(var currentIndex: Int) : Event()

    //歌曲收藏列表播放
    data class ChangePlayMusicCollect(var currentIndex: Int) : Event()

    //编辑收藏列表
    data class ChangeEditCollectList(var status: Boolean) : Event()

    //播放列表切换
    object MusicListChangeEvent : Event()

    //房间引导消息
    data class RoomGuideEvent(var position: Int? = 0, var isJump: Boolean) : Event()


    /**
     * 本地音浪变化
     */
    data class CapturedSoundLevelUpdateEvent(var soundLevel: Float) : Event()

    /**
     * 远端音浪变化
     */
    data class RemoteSoundLevelUpdateEvent(var soundLevels: HashMap<String, Float>?) : Event()

    /**
     * 显示幸运礼物
     */
    object ShowLuckyGiftEvent : Event()

    //切换账号刷新数据
    object RefreshChangeAccountEvent : Event()


    //刷新动态通知(点赞和互动消息)
    object MsgRefreshDynamicNoticeEvent : Event()


    //星际庄园游戏
    data class H5InterstellarEvent(var content:String) : Event()

    //通知权限是否开启
    object NotificationEventOpen  : Event()
}
