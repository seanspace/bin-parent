/**
 * Work Queues  工作队列 <tr/>
 * Created by xiaobin on 2016/10/5.<tr/>
 * 在第一篇教程中，我们已经写了一个从已知队列中发送和获取消息的程序。在这篇教程中，我们将创建一个工作队列（Work Queue），<tr/>
 * 它会发送一些耗时的任务给多个工作者（Worker）。<tr/>
 *
 * 工作队列（又称：任务队列——Task Queues）是为了避免等待一些占用大量资源、时间的操作。当我们把任务（Task）当作消息发送到队列中，<tr/>
 * 一个运行在后台的工作者（worker）进程就会取出任务然后处理。当你运行多个工作者（workers），任务就会在它们之间共享。<tr/>
 */
package com.bin.rabbitmq.workqueue;